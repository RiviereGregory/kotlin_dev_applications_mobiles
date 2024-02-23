package mrs.riverjach.allerplusloinaveckotlin.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import mrs.riverjach.allerplusloinaveckotlin.model.UserForBD

private const val NAME = "name"

private const val AGE = "age"

private const val EMAIL = "email"

private const val TABLE_USERS = "users"

class Database(context: Context) : SQLiteOpenHelper(context, "users.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_USERS(id INTEGER PRIMARY KEY, $NAME TEXT, $AGE INTEGER, $EMAIL TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // Code si changement de version de la database...
    }

    fun createUser(user: UserForBD) {
        val values = ContentValues()
        values.put(NAME, user.name)
        values.put(AGE, user.age)
        values.put(EMAIL, user.email)
        writableDatabase.insert(TABLE_USERS, null, values)
        writableDatabase.close()
    }

    fun getUserCount(): Int = DatabaseUtils
        .queryNumEntries(readableDatabase, TABLE_USERS, null)
        .toInt()

    @SuppressLint("Range")
    fun getAllUsers(): MutableList<UserForBD> {
        val users = mutableListOf<UserForBD>()
        readableDatabase.rawQuery("SELECT * FROM $TABLE_USERS", null).use { cursor ->
            while (cursor.moveToNext()) {
                val user = UserForBD(
                    cursor.getString(cursor.getColumnIndex(NAME)),
                    cursor.getInt(cursor.getColumnIndex(AGE)),
                    cursor.getString(cursor.getColumnIndex(EMAIL))
                )
                users.add(user)
            }
        }
        return users
    }


}
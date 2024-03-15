@file:JvmName("DatabaseKt")

package mrs.riverjach.meteo

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import mrs.riverjach.meteo.city.City

private const val DATABASE_NAME = "meteodb"
private const val DATABASE_VERSION = 1
private const val CITY_TABLE_NAME = "city"
private const val CITY_KEY_ID = "id"
private const val CITY_KEY_NAME = "NAME"
private const val CITY_TABLE_CREATE = """
    CREATE TABLE $CITY_TABLE_NAME(
    $CITY_KEY_ID INTEGER PRIMARY KEY,
    $CITY_KEY_NAME TEXT
)
"""
private const val CITY_SELECT_ALL = "SELECT * FROM $CITY_TABLE_NAME"

class Database(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CITY_TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Code pour changement de version de la BDD
    }

    fun createCity(city: City): Boolean {
        val values = ContentValues()
        values.put(CITY_KEY_NAME, city.name)
        val id = writableDatabase.insert(CITY_TABLE_NAME, null, values)
        return id != -1L
    }

    @SuppressLint("Range")
    fun getAllCities(): MutableList<City> {
        val cities = mutableListOf<City>()
        readableDatabase.rawQuery(CITY_SELECT_ALL, null).use { cursor ->
            while (cursor.moveToNext()) {
                val city = City(
                    cursor.getInt(cursor.getColumnIndex(CITY_KEY_ID)),
                    cursor.getString(cursor.getColumnIndex(CITY_KEY_NAME))
                )
                cities.add(city)
            }
        }
        return cities
    }
}
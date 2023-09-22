package mrs.riverjach.chapitre3activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mrs.riverjach.chapitre3activity.metier.User

class UserActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val user = intent.getParcelableExtra<User>("user")
        val name = findViewById<TextView>(R.id.name)
        val age = findViewById<TextView>(R.id.age)
        Log.i("UserActivity", "nom : ${user?.name} - âge : ${user?.age}")
        name.text = "Nom : ${user?.name}"
        age.text = "Age : ${user?.age}"
    }
}
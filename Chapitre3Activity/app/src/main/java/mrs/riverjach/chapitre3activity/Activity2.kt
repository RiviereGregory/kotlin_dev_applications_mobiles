package mrs.riverjach.chapitre3activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val extras: Bundle? = intent.extras
        val name = extras?.getString("name")
        val age = extras?.getInt("age")
        Log.i("Activity1", "nom : $name - âge : $age")
    }
}
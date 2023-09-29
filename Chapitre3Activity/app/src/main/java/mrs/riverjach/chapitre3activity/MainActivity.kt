package mrs.riverjach.chapitre3activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import mrs.riverjach.chapitre3activity.metier.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.startButton)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val user = User("Tom", 16)
        button.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
        button1.setOnClickListener {
            val intent = Intent(this, DimensionUnites::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, LinearLayoutSample::class.java)
            startActivity(intent)
        }
    }
}
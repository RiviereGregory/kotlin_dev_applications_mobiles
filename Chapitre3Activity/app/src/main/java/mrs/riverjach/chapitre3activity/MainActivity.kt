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
        val user = User("Tom", 16)
        button.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}
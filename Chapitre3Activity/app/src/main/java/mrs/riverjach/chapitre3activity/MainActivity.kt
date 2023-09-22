package mrs.riverjach.chapitre3activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.start_activity)
        button.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("name", "Tom")
            intent.putExtra("age", 16)
            startActivity(intent)
        }
    }
}
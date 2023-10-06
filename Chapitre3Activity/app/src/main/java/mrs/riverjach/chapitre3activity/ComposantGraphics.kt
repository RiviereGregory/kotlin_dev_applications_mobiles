package mrs.riverjach.chapitre3activity

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ComposantGraphics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composant_graphics)
        val monImageView: ImageView = findViewById(R.id.monImage)
        val maCheckBox: CheckBox = findViewById(R.id.maCheckBox)

        monImageView.visibility = View.INVISIBLE
        maCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                monImageView.visibility = View.VISIBLE
            } else {
                monImageView.visibility = View.INVISIBLE
            }
        }
    }
}
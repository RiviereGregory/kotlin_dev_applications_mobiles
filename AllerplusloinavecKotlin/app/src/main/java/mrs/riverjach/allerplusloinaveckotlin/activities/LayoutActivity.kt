package mrs.riverjach.allerplusloinaveckotlin.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mrs.riverjach.allerplusloinaveckotlin.R

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        fonctioni18n()
    }

    fun refresh(i: Int) {
        val textViewTitre = findViewById(R.id.textViewTitre) as TextView
        textViewTitre.text = getString(R.string.layoutTitre, 5 * i)
        val textViewFarine = findViewById(R.id.textViewFarine) as TextView
        textViewFarine.text = getString(R.string.layoutFarine, 125 * i)
        val textViewOeuf = findViewById(R.id.textViewOeuf) as TextView
        textViewOeuf.text = resources.getQuantityString(R.plurals.layoutOeuf, i, i)
    }

    private fun fonctioni18n() {
        var i = 2
        refresh(2)
        val buttonPlus = findViewById(R.id.boutonPlus) as Button
        buttonPlus.setOnClickListener {
            i++
            refresh(i)
        }
        val buttonMoins = findViewById(R.id.boutonMoins) as Button
        buttonMoins.setOnClickListener {
            if (i > 1) {
                i--
                refresh(i)
            }
        }
    }
}
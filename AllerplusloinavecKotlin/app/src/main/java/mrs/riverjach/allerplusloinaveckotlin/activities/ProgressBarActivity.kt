package mrs.riverjach.allerplusloinaveckotlin.activities

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mrs.riverjach.allerplusloinaveckotlin.R

class ProgressBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress_bar_activity)
        progressBarCyclique()
        progressBarProgression()
    }

    private fun progressBarCyclique() {
        val myProgressBar = findViewById(R.id.myProgressBar) as ProgressBar
        val myButton = findViewById(R.id.myButton) as Button
        myButton.setOnClickListener {
            if (myButton.text == "GO") {
                myProgressBar.visibility = View.VISIBLE
                myButton.text = "Stop"
            } else {
                myProgressBar.visibility = View.INVISIBLE
                myButton.text = "GO"
            }
        }
    }

    private fun progressBarProgression() {
        val myProgressBar = findViewById(R.id.myProgressBar2) as ProgressBar
        val myButton = findViewById(R.id.myButton2) as Button
        val myTextView = findViewById(R.id.myTextView2) as TextView
        myButton.setOnClickListener {
            myButton.visibility = View.INVISIBLE
            myProgressBar.visibility = View.VISIBLE
            myTextView.visibility = View.VISIBLE
            val mytimer = object : CountDownTimer(10000, 200) {
                override fun onTick(p0: Long) {
                    myProgressBar.max = 10000
                    myProgressBar.incrementProgressBy(200)
                    myProgressBar.secondaryProgress += 300
                }

                override fun onFinish() {
                    myTextView.text = "Chargement des données effectué!"
                }
            }
            mytimer.start()
        }
    }
}
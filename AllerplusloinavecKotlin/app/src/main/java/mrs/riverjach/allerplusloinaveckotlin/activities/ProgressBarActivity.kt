package mrs.riverjach.allerplusloinaveckotlin.activities

import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.progress_bar_activity.myButton3
import kotlinx.android.synthetic.main.progress_bar_activity.myProgressBar3
import mrs.riverjach.allerplusloinaveckotlin.R

class ProgressBarActivity : AppCompatActivity() {

    companion object {
        const val START = 100
        const val RUNNING = 0
        const val FINISH = -1
    }

    lateinit var myHandler: Handler
    lateinit var myThread: Thread

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress_bar_activity)
        progressBarCyclique()
        progressBarProgression()
        progressBarWithThread()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun progressBarWithThread() {
        myProgressBar3.max = 100
        myThread = Thread {
            for (i in 0..100) {
                println(":$i")
                try {
                    Thread.sleep(100)
                } catch (ex: InterruptedException) {
                    ex.printStackTrace()
                }
                val message = Message()
                message.what = RUNNING
                message.arg1 = i
                myHandler.sendMessage(message)
            }
            myHandler.sendEmptyMessage(FINISH)
        }
        myButton3.setOnClickListener {
            println(myThread.isAlive)
            if (!myThread.isAlive) {
                myHandler.sendEmptyMessage(START)
            }
            myButton3.isEnabled = false
        }
        myHandler = MyHandler(this, myThread)
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

class MyHandler(
    val progressBarActivity: ProgressBarActivity,
    val myThread: Thread
) :
    Handler(progressBarActivity.mainLooper) {
    override fun handleMessage(msg: Message) {
        val myTextView = progressBarActivity.findViewById(R.id.myTextView3) as TextView
        val myProgressBar = progressBarActivity.findViewById(R.id.myProgressBar3) as ProgressBar

        val state = msg.what
        val number = msg.arg1
        when (state) {
            0 -> {
                myTextView.text = "COUNT $number"
                myProgressBar.progress = number
            }

            -1 -> myTextView.text = "FIN TRAITEMENT"
            100 -> {
                myTextView.text = "DEBUT TRAITEMENT"
                myThread.start()
            }

            else -> myTextView.text = "COUNT"
        }

    }
}

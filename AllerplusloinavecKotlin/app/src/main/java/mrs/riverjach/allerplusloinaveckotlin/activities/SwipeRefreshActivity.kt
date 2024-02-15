package mrs.riverjach.allerplusloinaveckotlin.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import mrs.riverjach.allerplusloinaveckotlin.R

class SwipeRefreshActivity : AppCompatActivity() {
    val swipeRefreshLayout: SwipeRefreshLayout by lazy {
        findViewById(R.id.swipeRefreshLayout)
    }

    val textViewSwipe: TextView by lazy {
        findViewById(R.id.textViewSwipe)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swipe_refresh_activity)


        swipeRefreshLayout.setOnRefreshListener {
            textViewSwipe.text = "Kotlin"
            stopRefresh()
        }

        val button: Button = findViewById(R.id.swipeRefreshButton)
        button.setOnClickListener {
            swipeRefreshLayout.isRefreshing = true
            textViewSwipe.text = "Kotlin"
            stopRefresh()
        }
    }

    private fun stopRefresh() {
        val handler = Handler()
        handler.postDelayed({ swipeRefreshLayout.isRefreshing = false }, 2000)
    }
}
package mrs.riverjach.allerplusloinaveckotlin.activities

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.swipe_refresh_activity.swipeRefreshButton
import kotlinx.android.synthetic.main.swipe_refresh_activity.swipeRefreshLayout
import kotlinx.android.synthetic.main.swipe_refresh_activity.textViewSwipe
import mrs.riverjach.allerplusloinaveckotlin.R

class SwipeRefreshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swipe_refresh_activity)


        swipeRefreshLayout.setOnRefreshListener {
            textViewSwipe.text = "Kotlin"
            stopRefresh()
        }

        swipeRefreshButton.setOnClickListener {
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
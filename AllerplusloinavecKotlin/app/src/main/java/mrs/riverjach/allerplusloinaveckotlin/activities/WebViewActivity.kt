package mrs.riverjach.allerplusloinaveckotlin.activities

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mrs.riverjach.allerplusloinaveckotlin.R

class WebViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    val webViewClient: WebViewClient = object : WebViewClient() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_view_activity)
        webView = findViewById(R.id.myWebView)
        webView.webViewClient = webViewClient
        webView.settings.setAllowContentAccess(true);
        webView.loadUrl("https://developer.android.com/develop/ui/views/layout/webapps/webview")
        if (webView.settings.javaScriptEnabled == false) {
            Toast.makeText(
                this@WebViewActivity,
                "Javascript non supporté !!", Toast.LENGTH_LONG
            )
                .show()
        }

    }
}
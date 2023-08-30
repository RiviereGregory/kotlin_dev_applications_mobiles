package mrs.riverjach.console

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mrs.riverjach.console.mesclasses.cast.demoSmartCast
import mrs.riverjach.console.mesclasses.cast.longueurStringSafeCast
import mrs.riverjach.console.mesclasses.cast.longueurStringUnsafeCast
import mrs.riverjach.console.ui.theme.ConsoleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsoleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val x = "Kotlin"
        val y = 18
        val z = intArrayOf(1, 5, 10)
        val a = 1.2F
        demoSmartCast(x)
        demoSmartCast(y)
        demoSmartCast(z)
        demoSmartCast(a)

        // unsafe Cast
        val xx = 1
        // xx as String -> CastClass exception
        val yy: String = xx.toString()
        longueurStringUnsafeCast(yy)

        // Safe Cast
        val yyy: String? = xx as? String
        longueurStringSafeCast(yyy)
        println(yyy)

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConsoleTheme {
        Greeting("Android")
    }
}
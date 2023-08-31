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
import mrs.riverjach.console.mesclasses.generique.Box
import mrs.riverjach.console.mesclasses.generique.demo
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

        val tab1 = arrayOf(1, 2, 3, 4)
        val tab2 = arrayOf("Kotlin", "Langage", "Android")
        val tab3 = arrayOf(1.02, 2.1, 3.1415)
        println(demo(tab1))
        println(demo(tab2))
        println(demo(tab3))

        val x = Box<Int>(5)
        val y = Box<String>("Java")
        println("x contient la valeur : ${x.value}")
        println("y contient la valeur : ${y.value}")
        y.set("Kotlin")
        println("y contient la valeur : ${y.value}")
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
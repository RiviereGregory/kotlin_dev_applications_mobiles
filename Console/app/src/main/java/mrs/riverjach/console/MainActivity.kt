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
import mrs.riverjach.console.mesclasses.nestedclass.Outer
import mrs.riverjach.console.mesclasses.nestedclass.Palette
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

        // exemple 1
        val demo = Outer.Nested().foo()
        println(demo)
        // exemple 2
        val chargement = Palette(3)
        chargement.poids[0] = Palette.Item1(50)
        chargement.volume[0] = Palette.Item2(3)
        chargement.poids[1] = Palette.Item1(100)
        chargement.volume[1] = Palette.Item2(5)
        chargement.poids[2] = Palette.Item1(200)
        chargement.volume[2] = Palette.Item2(8)

        for (i in 0..2) {
            chargement.showPalette(i)
        }
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
package mrs.riverjach.console

import android.graphics.Color
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
import mrs.riverjach.console.mesclasses.Voiture
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

        val maVoiture = Voiture("Subaru", "BRZ", Color.BLUE, 0)
        val maVoiture2 = Voiture("Peugeot", "208", Color.RED)
        val maVoiture3 = Voiture("Peugeot", "5008")
        val maVoiture4 = Voiture()
        maVoiture.klaxonner()
        println(maVoiture)
        println(maVoiture2)
        println(maVoiture3)
        println(maVoiture4)
        maVoiture.accelerer(30)
        println("Voiture 1 vitesse ${maVoiture.vitesse}")
        maVoiture2.accelerer(40)
        println("Voiture 2 vitesse ${maVoiture2.vitesse}")
        maVoiture3.accelerer(50)
        println("Voiture 3 vitesse ${maVoiture3.vitesse}")
        maVoiture4.accelerer(60)
        println("Voiture 4 vitesse ${maVoiture4.vitesse}")
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
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
        val nom = "Tom"
        val age = 16
        val taille = 1.60F
        val dev = true
        when {
            age < 13 -> println("$nom, tu ne peux pas regarder ce film")
            age in 14..17 -> println("$nom, tu peux regader ce film avec tes parents")
            else -> println("$nom, tu peux regarder ce film")
        }

        when {
            age < 5 -> println("Tu ne peux pas t'inscrire dans cette activité")
            taille < 1F -> println("Tu ne peux pas t'inscrire dans cette activité")
            dev.and(age >= 18) -> println("Tu devenir formateur")
            else -> println("Tu peux t'inscrire dans cette activité")
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
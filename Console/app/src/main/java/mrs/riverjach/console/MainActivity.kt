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

        // Boucle for : parcours d'un array de string
        val nom = arrayOf("Pim", "Pam", "Poum", "Tom", "Bob")
        for (name in nom) {
            print(name)
            print(" ")
        }
        println("") //saut de ligne

        // Boucle for : affichage des carrés de 0 à 9
        for (i in 0..9) {
            print(i * i)
            print(" ")
        }
        println("") //saut de ligne

        // Boucle for croissante de pas 3
        for (i in 0..39 step 3) {
            print(i)
            print(" ")
        }
        println("") //saut de ligne

        // Boucle for decroissante de pas 2
        for (i in 10 downTo 0 step 2) {
            print(i)
            print(" ")
        }
        println("") //saut de ligne
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
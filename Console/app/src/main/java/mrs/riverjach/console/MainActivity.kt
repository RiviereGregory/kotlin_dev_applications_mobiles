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
import mrs.riverjach.console.mesclasses.interfa.Avion
import mrs.riverjach.console.mesclasses.interfa.Bicyclette
import mrs.riverjach.console.mesclasses.interfa.Helicoptere
import mrs.riverjach.console.mesclasses.interfa.Moto
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

        val maMoto = Moto()
        maMoto.nom = "Suzuki RZK"
        maMoto.poids = 200
        maMoto.vitesse = 110
        val maBicyclette = Bicyclette()
        maBicyclette.nom = "RockRider500"
        maBicyclette.poids = 15
        maBicyclette.vitesse = 30
        val monAvion = Avion()
        monAvion.nom = "Rafale"
        monAvion.poids = 5000
        monAvion.vitesse = 950
        monAvion.altitude = 8500
        val monHelicoptere = Helicoptere()
        monHelicoptere.nom = "Helicop83"
        monHelicoptere.poids = 2500
        monHelicoptere.vitesse = 250
        monHelicoptere.altitude = 500

        println("${maMoto.nom}"); maMoto.Rouler(); maMoto.FaireLePlein()
        println("${maBicyclette.nom}"); maBicyclette.Rouler()
        println("${monAvion.nom}"); monAvion.Rouler(); monAvion.FaireLePlein();monAvion.Voler()
        println("${monHelicoptere.nom}"); monHelicoptere.Voler(); monHelicoptere.FaireLePlein()

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
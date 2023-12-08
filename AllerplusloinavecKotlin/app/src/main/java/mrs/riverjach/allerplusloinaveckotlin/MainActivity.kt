package mrs.riverjach.allerplusloinaveckotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import mrs.riverjach.allerplusloinaveckotlin.utils.Armes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Armes.valueOf("ARC").degats = 15
        for (arme in Armes.values()) {
            arme.description()
            println(arme.commentaire())
        }
    }
}

package mrs.riverjach.allerplusloinaveckotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import mrs.riverjach.allerplusloinaveckotlin.utils.Armes
import mrs.riverjach.allerplusloinaveckotlin.utils.Figure
import mrs.riverjach.allerplusloinaveckotlin.utils.Figure.Unite.description

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enumClass()
        sealedClass()
    }

    private fun sealedClass() {
        var figures = mutableListOf<Figure>()
        figures.add(Figure.Cercle(3.0))
        figures.add(Figure.Carre(7.5))
        figures.add(Figure.Rectangle(3.55, 4.0))
        figures.add(Figure.Triangle(3.5, 4.1, 6.2))
        figures.add(Figure.Unite)

        for (figure in figures) {
            description(figure)
        }


    }

    private fun enumClass() {
        Armes.valueOf("ARC").degats = 15
        for (arme in Armes.values()) {
            arme.description()
            println(arme.commentaire())
        }
    }
}

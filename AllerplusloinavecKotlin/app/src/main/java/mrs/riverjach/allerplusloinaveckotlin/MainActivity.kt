package mrs.riverjach.allerplusloinaveckotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import mrs.riverjach.allerplusloinaveckotlin.utils.Armes
import mrs.riverjach.allerplusloinaveckotlin.utils.Figure
import mrs.riverjach.allerplusloinaveckotlin.utils.Figure.Unite.description
import mrs.riverjach.allerplusloinaveckotlin.utils.filterArrayInt
import mrs.riverjach.allerplusloinaveckotlin.utils.filterArrayIntMultiplek
import mrs.riverjach.allerplusloinaveckotlin.utils.filterMulitple
import mrs.riverjach.allerplusloinaveckotlin.utils.filterMultiple3
import mrs.riverjach.allerplusloinaveckotlin.utils.filterPair
import mrs.riverjach.allerplusloinaveckotlin.utils.filterPositif
import java.util.Arrays

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enumClass()
        sealedClass()
        highOrderFunction()
        lambdaFunction()
    }

    private fun lambdaFunction() {
        val numbers = arrayOf(-121, -119, -57, -50, -8, -6, 0, 3, 5, 7, 51, 58, 68, 99, 122)
        println("Tableau initial : ${Arrays.toString(numbers)}")
        val numbersPositif = numbers.filter { it >= 0 }
        println("Tableau filtre positifavec lambda : ${Arrays.toString(numbersPositif.toIntArray())}")

    }

    private fun highOrderFunction() {
        val numbers = arrayOf(-121, -119, -57, -50, -8, -6, 0, 3, 5, 7, 51, 58, 68, 99, 122)
        println("Tableau initial : ${Arrays.toString(numbers)}")
        val numbersPositif = filterArrayInt(numbers, ::filterPositif)
        println("Tableau filtre positif : ${Arrays.toString(numbersPositif)}")
        val numbersPair = filterArrayInt(numbers, ::filterPair)
        println("Tableau filtre Pair : ${Arrays.toString(numbersPair)}")
        val numbersMultiple3 = filterArrayInt(numbers, ::filterMultiple3)
        println("Tableau filtre Multiple 3 : ${Arrays.toString(numbersMultiple3)}")
        val numbersPositifMultiple3 =
            filterArrayInt(filterArrayInt(numbers, ::filterPositif), ::filterMultiple3)
        println("Tableau filtre positif + Multiple 3 : ${Arrays.toString(numbersPositifMultiple3)}")

        // Exemple 2
        for (k in 2..9) {
            var numbersFiltre = filterArrayIntMultiplek(numbers, k, ::filterMulitple)
            println("Tableau Multiple de $k : ${Arrays.toString(numbersFiltre)}")
        }
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

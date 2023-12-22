package mrs.riverjach.allerplusloinaveckotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import mrs.riverjach.allerplusloinaveckotlin.model.User
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
        elvisOperator()
        collectionList()
    }

    private fun collectionList() {
        exempleList1()
        exempleList2()
    }

    private fun exempleList1() {
        val maList = listOf(5, 10, 20, 50, 100, 200, 500)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 2 : ${maList[2]}")
        println("Le dernier élément : ${maList.last()}")
        println("Index de l'Elément 200 : ${maList.indexOf(200)}")
        println("Index de l'Elément 1000 : ${maList.indexOf(1000)}")
    }

    private fun exempleList2() {
        val maList = listOf(20, "Tom", 1250.30)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 0 : ${maList[0]}")
        println("Contient \"Bob\" ? : ${maList.contains("Bob")}")
        println("Contient \"Tom\" ? : ${maList.contains("Tom")}")
    }

    private fun elvisOperator() {
        var name: String? = null
        var sizeElvis: Int? = name?.length ?: -1
        println(sizeElvis)

        val user1 = User(null, null)
        val user2 = User("Tom", null)
        val user3 = User("Tom", "tomtom@kotlin.com")

        user1.updateName("bob")
        user2.updateName(null)

        try {
            user3.updateEmail(null)
        } catch (e: Exception) {
            println(e.message)
        }
        try {
            user1.updateEmail("bobbob@kotlin.com")
        } catch (e: Exception) {
            println(e.message)
        }

        println("user1 : ${user1.name} ; ${user1.email}")
        println("user2 : ${user2.name} ; ${user2.email}")
        println("user3 : ${user3.name} ; ${user3.email}")


    }

    private fun lambdaFunction() {
        val numbers = arrayOf(-121, -119, -57, -50, -8, -6, 0, 3, 5, 7, 51, 58, 68, 99, 122)
        println("Tableau initial : ${Arrays.toString(numbers)}")
        val numbersPositif = numbers.filter { it >= 0 }
        println("Tableau filtre positif avec lambda : ${Arrays.toString(numbersPositif.toIntArray())}")
        val numbersPositifMultiple3 = (numbers.filter { it >= 0 }).filter { it % 3 == 0 }
        println(
            "Tableau filtre positif + Multiple 3 avec lambda : ${
                Arrays.toString(
                    numbersPositifMultiple3.toIntArray()
                )
            }"
        )

        val numbersPair = numbers.filter { it % 2 == 0 }
        numbersPair.forEach { print("v=$it ;") }
        println()
        numbersPair.forEachIndexed { index, valeur -> print("i=$index/v=$valeur ;") }
        println()
        numbersPair.forEachIndexed { index, _ -> print("j=${2 * index + 1} ;") }
        println()

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

package mrs.riverjach.allerplusloinaveckotlin

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
import mrs.riverjach.allerplusloinaveckotlin.utils.isEvent
import mrs.riverjach.allerplusloinaveckotlin.utils.swap
import mrs.riverjach.allerplusloinaveckotlin.utils.switch
import java.util.Arrays

private const val SEPARATOR = "###### ###### #####"

class MainActivity : AppCompatActivity() {
    val helloWorldLazy: TextView by lazy {
        println("Initialisation de helloWorldLazy")
        findViewById(R.id.hello_world) as TextView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        println(SEPARATOR)
        println("###### enumClass #####")
        println(SEPARATOR)
        enumClass()
        println(SEPARATOR)
        println("###### sealedClass #####")
        println(SEPARATOR)
        sealedClass()
        println(SEPARATOR)
        println("###### highOrderFunction #####")
        println(SEPARATOR)
        highOrderFunction()
        println(SEPARATOR)
        println("###### lambdaFunction #####")
        println(SEPARATOR)
        lambdaFunction()
        println(SEPARATOR)
        println("###### elvisOperator #####")
        println(SEPARATOR)
        elvisOperator()
        println(SEPARATOR)
        println("###### collectionList #####")
        println(SEPARATOR)
        collectionList()
        println(SEPARATOR)
        println("###### collectionSet #####")
        println(SEPARATOR)
        collectionSet()
        println(SEPARATOR)
        println("###### collectionMap #####")
        println(SEPARATOR)
        collectionMap()
        println("###### Lazy init #####")
        println(SEPARATOR)
        println(helloWorldLazy.text)
        println(helloWorldLazy.text)
        println("###### Lazy init 2#####")
        println(SEPARATOR)
        lazyInit()
        print(SEPARATOR)
        println(SEPARATOR)
        println("###### Fonction Extension #####")
        print(SEPARATOR)
        println(SEPARATOR)
        println("###### Custom 1 #####")
        fonctionExtensionCustom1()
        println("###### Custom 2 #####")
        fonctionExtensionCustom2()
        println("###### Custom 3 #####")
        fonctionExtensionCustom3()
        println("###### Native Kotlin #####")
        fonctionExtensionNativeKotlin()
    }

    private fun fonctionExtensionNativeKotlin() {
        println(" ==> LET")
        println("    Permet de vérifier que la variable est != null")
        println("    Ex : File(\"config\").let{ file -> ... ")
        println(" ==> APPLY")
        println("    Permet d executer unlambda sur un objet et d'affecter le résutat")
        println("    Ex : var file = File(\"config\")..apply{mkdir()} ")
        println(" ==> WITH")
        println("    Permet de modifier plusieurs variable d'un objet")
        println("    Ex : var paint = Paint() ")
        println("    with(paint) { ")
        println("       alpha = 130 ")
        println("       color = color.RED ")
        println("       strokeWidth = 2.0f} ")
        println(" ==> RUN")
        println("    combinaison de LET et WITH")
        println("     - restreindre la portée")
        println("     - appeler une variable sans avoir à la référencer explicitement")
        println("    Ex : var monString = StringBuilder().run{ ")
        println("       append(\"koltin\") ")
        println("       append(\"et Java sont\") ")
        println("       append(2) ")
        println("       append(\" langages inter-operable\") ")
        println("       toString() } ")
        println(" ==> USE")
        println("    Permet de fermer automatiquement les objet Closeable")
        println("    Ex : val outPutStreamWriter = OutPutStreamWriter(file) ")
        println("         outPutStreamWriter.use{ ")
        println("            properties.store(it,null) ")
        println("            println(\"Sauvegarde effecuée\" ")
        println("         } ")
    }

    private fun fonctionExtensionCustom3() {
        val monTextView = findViewById(R.id.hello_world) as TextView
        val myTimer = object : CountDownTimer(20000, 1000) {
            override fun onTick(p0: Long) {
                monTextView.switch()
            }

            override fun onFinish() {
                println("Timer is finish")
            }
        }
        myTimer.start()
    }

    private fun fonctionExtensionCustom2() {
        val maList = mutableListOf<Int>(1, 2, 5, 10, 20, 40, 100)
        println(maList)
        maList.swap(0, 3)
        println("Swap list index 0 and 3")
        println(maList)
    }

    private fun fonctionExtensionCustom1() {
        println(21.isEvent())
        val age = 56
        println(age.isEvent())
    }

    private fun lazyInit() {
        val user = User("Tom", "tomtom@kotlin.com")
        println("premier appel :")
        println(user.sports)
        println("deuxième appel :")
        println(user.sports)

    }

    private fun collectionMap() {
        val maMap = mutableMapOf(
            44000 to "NANTES",
            44110 to "SOUDAN",
            44600 to "SAINT-NAZAIRE"
        )
        println(maMap)
        maMap.put(44400, "REZE")
        println(maMap)
        println("Valeur correspondant à la clé 44600 : ${maMap[44600]}")
        // Utilisation key et map[key]
        for (key in maMap.keys) {
            println("clé : $key => valeur : ${maMap[key]}")
        }
        // Utilisation entry
        for (entry in maMap.entries) {
            println("clé : ${entry.key} ==> valeur : ${entry.value}")
        }
        // Utilisation key et value
        for ((key, value) in maMap) {
            println("clé : $key ===> valeur : $value")
        }

    }

    private fun collectionSet() {
        val monSet = mutableSetOf("Tom", 1500, "Charlotte", 28.56, "Morgane", 1200)
        val monSet2 = mutableSetOf(2, 5, 9, 18, 1, 5, 22, 50, 3)
        // Permet d'avoir un type Pair avec le prédicat vrai
        // et l'autre avec les autre élément
        val maListPartion = monSet.partition { it is String }
        println(maListPartion)
        println(maListPartion.first)
        println(maListPartion.second)
        // Permet de coupé la liste en collection plus petite
        val maListChunked = monSet2.sorted().chunked(3)
        println(maListChunked)
        for (i in 0..maListChunked.size - 1) {
            println(maListChunked[i])
        }
    }

    private fun collectionList() {
        exempleList1()
        exempleList2()
        exempleList3()
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

    private fun exempleList3() {
        val maList = mutableListOf<Int>(5, 10, 20, 50, 100, 200, 500)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 6 : ${maList[6]}")
        println("Contient 1000 : ${maList.contains(1000)}")
        maList.add(40)
        maList.add(100)
        maList.add(1000)
        println(maList)
        println("nombre d'éléments: ${maList.size}")
        println("Elément à l'index 6 : ${maList[6]}")
        println("Contient 1000 : ${maList.contains(1000)}")
        maList.remove(100)
        println(maList)
        maList.add(10)
        maList.add(300)
        maList.add(10)
        maList.add(300)
        println(maList)
        // remove tous les 10
        maList.removeAll { it == 10 }
        println(maList)
        maList.add(10)
        maList.add(300)
        maList.add(10)
        maList.add(300)
        println(maList)
        // filtre au dessus de 10
        val maList2 = maList.filter { it > 10 }
        println(maList2)
        // filtre au dessus ou égale de 10 et modulo 3
        val maList3 = maList.filter { it >= 10 }
            .filter { it % 3 == 0 }
        println(maList3)
        // mélange aléatoire
        val maListHazard = maList.shuffled()
        println(maListHazard)
        // tri ascendent
        val maListSorted = maList.sorted()
        println(maListSorted)
        // tri descendent
        val maListSortedDes = maList.sortedDescending()
        println(maListSortedDes)

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

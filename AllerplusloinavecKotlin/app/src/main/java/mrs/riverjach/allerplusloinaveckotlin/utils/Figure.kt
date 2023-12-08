package mrs.riverjach.allerplusloinaveckotlin.utils

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

sealed class Figure {
    abstract val name: String

    class Cercle(val rayon: Double) : Figure() {
        override val name: String = "Cercle"
    }

    class Carre(val cote: Double) : Figure() {
        override val name: String = "Carré"
    }

    class Rectangle(val largeur: Double, val longueur: Double) : Figure() {
        override val name: String = "Rectangle"
    }

    class Triangle(val cote1: Double, val cote2: Double, val cote3: Double) : Figure() {
        override val name: String = "Triangle"
    }

    object Unite : Figure() {
        override val name: String = "Unité"
    }

    fun perimetre(figure: Figure) =
        when (figure) {
            is Unite -> 1.0
            is Cercle -> 2 * PI * figure.rayon
            is Carre -> 4 * figure.cote
            is Rectangle -> 2 * (figure.largeur + figure.longueur)
            is Triangle -> figure.cote1 + figure.cote2 + figure.cote3
        }

    fun aire(figure: Figure) =
        when (figure) {
            is Unite -> 1.0
            is Cercle -> PI * figure.rayon.pow(2)
            is Carre -> figure.cote.pow(2)
            is Rectangle -> figure.largeur * figure.longueur
            is Triangle -> sqrt(
                perimetre(figure) * (perimetre(figure) - figure.cote1)
                        * (perimetre(figure) - figure.cote2) * (perimetre(figure) - figure.cote3)
            )
        }

    fun description(figure: Figure) {
        println("${figure.name} : de périmètre ${perimetre(figure)} et d'aire ${aire(figure)}")
    }
}

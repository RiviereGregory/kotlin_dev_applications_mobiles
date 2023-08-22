package mrs.riverjach.console.mesclasses

import android.graphics.Color

class Voiture(
    val marque: String,
    val modele: String,
    var couleur: Int,
    var vitesse: Int
) {
    constructor(marque: String, modele: String, couleur: Int) :
            this(marque, modele, couleur, 0)

    constructor(marque: String, modele: String) :
            this(marque, modele, Color.BLACK, 0)

    constructor() : this("Subaru", "BRZ", Color.BLUE, 0)

    fun klaxonner() {
        println("tuttuttut")
    }

    fun tourner(angle: Int) {
        println("Ma voiture tourne de $angle")
    }

    fun accelerer(gain: Int) {
        this.vitesse += gain
    }

    override fun toString(): String {
        return "Voiture(marque='$marque', modele='$modele', couleur=$couleur, vitesse=$vitesse)"
    }

}
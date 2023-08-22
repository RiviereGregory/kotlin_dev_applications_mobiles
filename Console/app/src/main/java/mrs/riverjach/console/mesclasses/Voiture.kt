package mrs.riverjach.console.mesclasses

class Voiture(
    val marque: String,
    val modele: String,
    var couleur: Int,
    var vitesse: Int
) {
    fun klaxonner() {
        println("tuttuttut")
    }

    fun tourner(angle: Int) {
        println("Ma voiture tourne de $angle")
    }

    fun accelerer(gain: Int) {
        this.vitesse += gain
    }
}
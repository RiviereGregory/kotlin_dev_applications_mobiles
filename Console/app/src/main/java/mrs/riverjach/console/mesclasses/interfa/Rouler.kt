package mrs.riverjach.console.mesclasses.interfa

interface Rouler {
    var vitesse: Int
    fun Rouler() {
        println("Je roule à une vitesse de : $vitesse km/s")
    }
}
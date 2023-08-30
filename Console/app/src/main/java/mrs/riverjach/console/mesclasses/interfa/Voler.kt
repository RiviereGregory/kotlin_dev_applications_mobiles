package mrs.riverjach.console.mesclasses.interfa

interface Voler {
    var vitesse: Int
    var altitude: Int
    fun Voler() {
        println("Je vole à une vitesse de : $vitesse km/h")
        println("Mon altitude est de : $altitude m")
    }
}
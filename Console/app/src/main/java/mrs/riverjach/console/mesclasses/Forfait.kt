package mrs.riverjach.console.mesclasses

class Forfait(val name: String) {
    val prix: Double

    init {
        when (name) {
            "PRIMO" -> prix = 9.99
            "ESENTIEL" -> prix = 19.99
            "PREMIUM" -> prix = 49.99
            else -> prix = -1.0
        }
    }
}
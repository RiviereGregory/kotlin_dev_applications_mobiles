package mrs.riverjach.allerplusloinaveckotlin.utils

enum class Armes(val nom: String, var poids: Double, var degats: Int) {
    ARC("Arc", 0.3, 12) {
        override fun commentaire() = "Armes légère maniable"
    },
    EPPE("Epée", 1.5, 2) {
        override fun commentaire() = "Arme lourde et puissante"
    },
    ARBALETE("Arbalète", 2.0, 20) {
        override fun commentaire() = "Peu efficace en mélée"
    },
    DAGUE("Dague", 0.2, 8) {
        override fun commentaire() = "Très maniable"
    };

    abstract fun commentaire(): String

    fun description() {
        println("$nom : Poids($poids), Dégâts($degats)")
    }
}
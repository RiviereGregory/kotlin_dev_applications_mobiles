package mrs.riverjach.console.encapsulation

class CompteAdo() : Compte() {
    private fun depotAutorise(depot: Double): Boolean {
        return solde + depot >= 0
    }

    override fun transaction(depot: Double) {
        if (depotAutorise(depot)) {
            super.transaction(depot)
        } else {
            println("Votre solde actuel ne permet pas de faire cette transaction")
        }
    }
}
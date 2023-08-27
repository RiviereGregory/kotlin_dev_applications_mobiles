package mrs.riverjach.console.encapsulation

open class Compte() {
    protected var solde: Double = 0.0
    open fun transaction(depot: Double) {
        solde += depot
        println("Votre solde est maintenant de : $solde")
    }
}
package mrs.riverjach.console.mesclasses.polymorphisme

open class Personne(var age: Int) {
    open fun direBonjour() {
        println("Enchanté de faire votre connaissance.")
    }
}
package mrs.riverjach.console.mesclasses.lateinit

class User(var name: String, var age: Int) {
    lateinit var pseudo: String
    fun showUser() {
        println("Nom : $name - Pseudo : $pseudo - Age : $age")
    }
}
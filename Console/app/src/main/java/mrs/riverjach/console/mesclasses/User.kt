package mrs.riverjach.console.mesclasses

data class User(val nom: String, val age: Int) {
    override fun toString(): String {
        return "nom de l'utilisateur : ${nom} - âge : ${age}"
    }
}

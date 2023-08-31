package mrs.riverjach.console.mesclasses.companionobject

class User(var name: String, var age: Int) {
    companion object Factory {
        val name_default: String = "user"
        val age_default = 18
        fun createUser() = User(name_default, age_default)
        fun showUser(user: User) {
            println("Nom : ${user.name} - Age : ${user.age}")
        }
    }
}
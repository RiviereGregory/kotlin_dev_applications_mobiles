package mrs.riverjach.allerplusloinaveckotlin.model

data class User(var name: String?, var email: String?) {
    fun updateName(name: String?) {
        this.name = name ?: "NoName"
    }

    fun updateEmail(email: String?) {
        this.email = email ?: throw IllegalArgumentException("Invalid email")
    }
}
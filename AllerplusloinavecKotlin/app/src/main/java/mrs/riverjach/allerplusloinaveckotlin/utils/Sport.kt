package mrs.riverjach.allerplusloinaveckotlin.utils

import mrs.riverjach.allerplusloinaveckotlin.model.User

class Sport {
    companion object {
        fun loadSports(user: User): List<String> {
            println("Chargement des sports pour ${user.name}")
            return listOf("Step", "Zumba", "Musculation", "Pilate")
        }
    }

}

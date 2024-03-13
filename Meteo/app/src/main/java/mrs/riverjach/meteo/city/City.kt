package mrs.riverjach.meteo.city

data class City(val id: Int, val name: String) {
    constructor(name: String) : this(-1, name)
}
package mrs.riverjach.meteo.meteo

data class Meteo(
    val description: String,
    val temperature: Float,
    val pressure: Int,
    val humidity: Int,
    val sunrise: Long,
    val sunset: Long,
    val iconUrl: String
)
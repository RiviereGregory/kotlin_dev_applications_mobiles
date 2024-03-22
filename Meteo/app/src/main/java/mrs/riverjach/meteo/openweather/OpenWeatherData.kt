package mrs.riverjach.meteo.openweather

import com.google.gson.annotations.SerializedName

data class WeatherWrapper(
    val weather: Array<WeatherData>,
    val main: MainData,
    val sys: SysData
)

data class WeatherData(
    val description: String,
    val icon: String
)

data class MainData(
    @SerializedName("temp") val temperature: Float,
    val pressure: Int,
    val humidity: Int
)

data class SysData(
    val sunrise: Long,
    val sunset: Long
)

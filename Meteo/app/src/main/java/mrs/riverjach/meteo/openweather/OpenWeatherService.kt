package mrs.riverjach.meteo.openweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "MY_KEY"

interface OpenWeatherService {
    @GET("data/2.5/weather?units=metric")
    fun getWeather(
        @Query("lang") lang: String,
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = API_KEY
    ): Call<WeatherWrapper>
}
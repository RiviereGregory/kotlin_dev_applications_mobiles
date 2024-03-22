package mrs.riverjach.meteo.openweather

import mrs.riverjach.meteo.meteo.Meteo

fun mapOpenWeatherDataToWeather(weatherWrapper: WeatherWrapper): Meteo {
    val weatherFirst = weatherWrapper.weather.first()
    return Meteo(
        description = weatherFirst.description,
        temperature = weatherWrapper.main.temperature,
        pressure = weatherWrapper.main.pressure,
        humidity = weatherWrapper.main.humidity,
        sunrise = weatherWrapper.sys.sunrise,
        sunset = weatherWrapper.sys.sunset,
        iconUrl = "https://openweathermap.org/img/wn/${weatherFirst.icon}.png"
    )
}
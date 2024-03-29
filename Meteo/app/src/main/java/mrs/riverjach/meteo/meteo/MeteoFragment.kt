package mrs.riverjach.meteo.meteo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_meteo.city
import kotlinx.android.synthetic.main.fragment_meteo.description
import kotlinx.android.synthetic.main.fragment_meteo.humidity
import kotlinx.android.synthetic.main.fragment_meteo.icon_image
import kotlinx.android.synthetic.main.fragment_meteo.pressure
import kotlinx.android.synthetic.main.fragment_meteo.sunrise
import kotlinx.android.synthetic.main.fragment_meteo.sunset
import kotlinx.android.synthetic.main.fragment_meteo.temperature
import mrs.riverjach.meteo.App
import mrs.riverjach.meteo.R
import mrs.riverjach.meteo.openweather.WeatherWrapper
import mrs.riverjach.meteo.openweather.mapOpenWeatherDataToWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.TimeZone

class MeteoFragment : Fragment() {
    private lateinit var cityName: String

    companion object {
        val EXTRA_CITY_NAME = "meteofragment.extras.EXTRA"

        fun newInstance() = MeteoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meteo, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity?.intent!!.hasExtra(EXTRA_CITY_NAME)) {
            activity?.intent!!.getStringExtra(EXTRA_CITY_NAME)?.let { updateMeteo(it) }
        }
    }

    private fun updateMeteo(cityName: String) {
        this.cityName = cityName
        val call = App.weatherService.getWeather(cityName)
        call.enqueue(object : Callback<WeatherWrapper> {
            override fun onFailure(call: Call<WeatherWrapper>, t: Throwable) {
                Toast.makeText(
                    activity,
                    getString(R.string.city_not_load, cityName),
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("Meteo Fragment", getString(R.string.city_not_load, cityName))
            }

            @SuppressLint("StringFormatMatches")
            override fun onResponse(
                call: Call<WeatherWrapper>,
                response: Response<WeatherWrapper>
            ) {
                response.body()?.let {
                    val meteo = mapOpenWeatherDataToWeather(it)
                    Log.i("Meteo Fragment", getString(R.string.city_load, meteo))
                    city.text = cityName
                    Picasso.get().load(meteo.iconUrl).into(icon_image)
                    description.text = meteo.description
                    temperature.text = getString(R.string.temperature_city, meteo.temperature)
                    pressure.text = getString(R.string.pressure_city, meteo.pressure)
                    humidity.text = getString(R.string.humidity_city, "${meteo.humidity}")
                    sunrise.text = utcToDate(meteo.sunrise)
                    sunset.text = utcToDate(meteo.sunset)

                }
            }
        })
    }

    @SuppressLint("SimpleDateFormat")
    private fun utcToDate(utc: Long): String {
        val time: String
        val dfm = SimpleDateFormat("HH:mm:ss")
        dfm.timeZone = TimeZone.getTimeZone("Europe/Paris")
        time = dfm.format(java.util.Date(utc * 1000))
        return time
    }
}
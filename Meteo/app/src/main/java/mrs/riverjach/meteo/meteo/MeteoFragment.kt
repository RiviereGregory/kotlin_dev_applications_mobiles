package mrs.riverjach.meteo.meteo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import mrs.riverjach.meteo.App
import mrs.riverjach.meteo.R
import mrs.riverjach.meteo.openweather.WeatherWrapper
import mrs.riverjach.meteo.openweather.mapOpenWeatherDataToWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            override fun onResponse(
                call: Call<WeatherWrapper>,
                response: Response<WeatherWrapper>
            ) {
                response.body()?.let {
                    val meteo = mapOpenWeatherDataToWeather(it)
                    Log.i("Meteo Fragment", getString(R.string.city_load, meteo))
                }
            }
        })
    }
}
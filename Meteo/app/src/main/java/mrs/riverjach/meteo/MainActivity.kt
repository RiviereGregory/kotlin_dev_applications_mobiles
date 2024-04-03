package mrs.riverjach.meteo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_meteo.city
import kotlinx.android.synthetic.main.fragment_meteo.description
import kotlinx.android.synthetic.main.fragment_meteo.humidity
import kotlinx.android.synthetic.main.fragment_meteo.icon_image
import kotlinx.android.synthetic.main.fragment_meteo.icon_sunrise
import kotlinx.android.synthetic.main.fragment_meteo.icon_sunset
import kotlinx.android.synthetic.main.fragment_meteo.pressure
import kotlinx.android.synthetic.main.fragment_meteo.sunrise
import kotlinx.android.synthetic.main.fragment_meteo.sunset
import kotlinx.android.synthetic.main.fragment_meteo.temperature
import mrs.riverjach.meteo.city.City
import mrs.riverjach.meteo.city.CityFragment
import mrs.riverjach.meteo.meteo.MeteoActivity
import mrs.riverjach.meteo.meteo.MeteoFragment

class MainActivity : AppCompatActivity(), CityFragment.CityFragmentListener {
    companion object {
        var langiso = "gb"
        var lang = "english"
    }

    fun lang(): String {
        var l = ""
        when (lang) {
            "english" -> l = "gb"
            "français" -> l = "fr"
        }
        return l

    }

    private lateinit var cityFragment: CityFragment
    private var currentCity: City? = null
    private var meteoFragment: MeteoFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        lang = this.resources.configuration.locale.getDisplayLanguage()
        langiso = lang()
        cityFragment = supportFragmentManager.findFragmentById(R.id.city_fragment) as CityFragment
        cityFragment.listener = this
        meteoFragment =
            supportFragmentManager.findFragmentById(R.id.meteo_fragment) as MeteoFragment?
    }

    override fun onCitySelected(city: City) {
        currentCity = city
        if (meteoFragment == null) {
            App.modeTablette = false
            startMeteoActivity(city)
        } else {
            App.modeTablette = true
            meteoFragment?.updateMeteo(city.name)
        }
    }

    override fun onEmptyCities() {
        icon_image.visibility = View.INVISIBLE
        city.text = ""
        description.text = ""
        temperature.text = ""
        pressure.text = ""
        humidity.text = ""
        sunrise.text = ""
        sunset.text = ""
        icon_sunset.visibility = View.INVISIBLE
        icon_sunrise.visibility = View.INVISIBLE
    }

    private fun startMeteoActivity(city: City) {
        val intent = Intent(this, MeteoActivity::class.java)
        intent.putExtra(MeteoFragment.EXTRA_CITY_NAME, city.name)
        startActivity(intent)
    }
}

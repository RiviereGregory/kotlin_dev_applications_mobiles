package mrs.riverjach.meteo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrs.riverjach.meteo.city.City
import mrs.riverjach.meteo.city.CityFragment
import mrs.riverjach.meteo.meteo.MeteoActivity
import mrs.riverjach.meteo.meteo.MeteoFragment

class MainActivity : AppCompatActivity(), CityFragment.CityFragmentListener {
    private lateinit var cityFragment: CityFragment
    private var currentCity: City? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        cityFragment = supportFragmentManager.findFragmentById(R.id.city_fragment) as CityFragment
        cityFragment.listener = this
    }

    override fun onCitySelected(city: City) {
        currentCity = city
        startMeteoActivity(city)
    }

    private fun startMeteoActivity(city: City) {
        val intent = Intent(this, MeteoActivity::class.java)
        intent.putExtra(MeteoFragment.EXTRA_CITY_NAME, city.name)
        startActivity(intent)
    }
}

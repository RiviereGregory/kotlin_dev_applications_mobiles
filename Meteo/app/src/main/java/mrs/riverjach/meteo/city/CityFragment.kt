package mrs.riverjach.meteo.city

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mrs.riverjach.meteo.App
import mrs.riverjach.meteo.Database
import mrs.riverjach.meteo.R

class CityFragment : Fragment(), CityAdapter.CityItemListener {
    private lateinit var database: Database
    private lateinit var cities: MutableList<City>
    private lateinit var recyclerView: RecyclerView
    private lateinit var cityAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        database = App.database
        cities = mutableListOf()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_city, container, false)
        recyclerView = view.findViewById(R.id.cities_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cities = database.getAllCities()
        cityAdapter = CityAdapter(cities, this)
        recyclerView.adapter = cityAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_city, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_creat_city -> {
                showCreateCityDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showCreateCityDialog() {
        val createCityFragment = CreateCityDialogFragment()
        createCityFragment.listener = object :
            CreateCityDialogFragment.CreateCityDialogListener {
            override fun onDialogPositiveClick(cityName: String) {
                saveCity(City(cityName))
            }

            override fun onDialogNegativeClick() {}
        }
        fragmentManager?.let { createCityFragment.show(it, "CreateCityDialogFragment") }

    }

    private fun saveCity(city: City) {
        if (database.createCity(city)) {
            cities.add(city)
            cityAdapter.notifyDataSetChanged()
        } else {
            Toast.makeText(
                context,
                getString(R.string.could_not_create_the_city),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCitySelected(city: City) {
        TODO("Not yet implemented")
    }

    override fun onCityDeleted(city: City) {
        TODO("Not yet implemented")
    }

}
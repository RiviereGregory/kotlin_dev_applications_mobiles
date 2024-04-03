package mrs.riverjach.meteo.city

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
    interface CityFragmentListener {
        fun onCitySelected(city: City)
        fun onEmptyCities()
    }

    var listener: CityFragmentListener? = null

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
        activity?.supportFragmentManager?.let {
            createCityFragment.show(
                it,
                "CreateCityDialogFragment"
            )
        }

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
        listener?.onCitySelected(city)
    }

    override fun onCityDeleted(city: City) {
        showDeleteCityDialog(city)
    }

    private fun showDeleteCityDialog(city: City) {
        val deleteCityDialogFragment = DeleteCityDialogFragment.newInstance(city.name)
        deleteCityDialogFragment.listener = object :
            DeleteCityDialogFragment.DeleteCityDialogListener {
            override fun onDialogPositiveClick() {
                deleteCity(city)
            }

            override fun onDialogNegativeClick() {}
        }
        activity?.supportFragmentManager?.let {
            deleteCityDialogFragment.show(
                it,
                "DeletedCityDialogFragment"
            )
        }
    }

    private fun deleteCity(city: City) {
        if (database.deleteCity(city)) {
            cities.remove(city)
            cityAdapter.notifyDataSetChanged()
            if (App.modeTablette) {
                selectFirstCity()
            }
            Toast.makeText(
                context,
                getString(R.string.city_has_deleted, city.name),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                context,
                getString(R.string.city_not_deleted, city.name),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun selectFirstCity() {
        when (cities.isEmpty() && App.modeTablette) {
            true -> listener?.onEmptyCities()
            false -> onCitySelected(cities.first())
        }
    }

}
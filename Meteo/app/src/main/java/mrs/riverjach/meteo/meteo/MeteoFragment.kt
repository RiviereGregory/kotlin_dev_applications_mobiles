package mrs.riverjach.meteo.meteo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mrs.riverjach.meteo.R

class MeteoFragment : Fragment() {
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
}
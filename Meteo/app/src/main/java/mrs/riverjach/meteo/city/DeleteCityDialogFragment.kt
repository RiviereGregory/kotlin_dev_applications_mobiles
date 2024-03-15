package mrs.riverjach.meteo.city

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import mrs.riverjach.meteo.R

class DeleteCityDialogFragment : DialogFragment() {
    interface DeleteCityDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    companion object {
        val EXTRA_CITY_NAME = "METEO.EXTRA_CITY_NAME"
        fun newInstance(cityName: String): DeleteCityDialogFragment {
            val fragment = DeleteCityDialogFragment()
            fragment.arguments = Bundle().apply {
                putString(EXTRA_CITY_NAME, cityName)
            }
            return fragment
        }
    }

    lateinit var cityName: String
    var listener: DeleteCityDialogListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityName = requireArguments().getString(EXTRA_CITY_NAME, "City")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = context?.let { AlertDialog.Builder(it) }
        builder!!.setTitle(getString(R.string.delete_city_title, cityName))
            .setPositiveButton(getString(R.string.delete_city),
                { _, _ -> listener?.onDialogPositiveClick() })
            .setNegativeButton(getString(R.string.cancel),
                { _, _ -> listener?.onDialogNegativeClick() })
        return builder!!.create()
    }

}
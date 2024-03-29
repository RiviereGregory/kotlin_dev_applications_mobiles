package mrs.riverjach.meteo.city

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import mrs.riverjach.meteo.R

class CreateCityDialogFragment : DialogFragment() {
    interface CreateCityDialogListener {
        fun onDialogPositiveClick(cityName: String)
        fun onDialogNegativeClick()
    }

    var listener: CreateCityDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = context?.let { AlertDialog.Builder(it) }
        val input = EditText(context)
        with(input) {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = context.getString(R.string.hint_name_city)
        }
        builder?.setTitle(getString(R.string.name_of_the_city))
            ?.setView(input)
            ?.setPositiveButton(
                getString(R.string.create_a_city)
            ) { _, _ ->
                listener?.onDialogPositiveClick(input.text.toString())
            }
            ?.setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
                listener?.onDialogNegativeClick()
            }
        return builder!!.create()
    }
}
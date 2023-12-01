package mrs.riverjach.blocnote.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import mrs.riverjach.blocnote.R

class ConfirmDeleteNoteDialogFragment(val noteTitre: String? = "") : DialogFragment() {
    interface ConfirmDeleteDialogListenner {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    var listenner: ConfirmDeleteDialogListenner? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setMessage("Voulez vous vraiment supprimer cette note : \"$noteTitre\"?")
            .setPositiveButton(
                getString(R.string.supprimer)
            ) { _, _ ->
                listenner?.onDialogPositiveClick()
            }
            .setNegativeButton(
                getString(R.string.annuler)
            ) { _, _ ->
                listenner?.onDialogNegativeClick()
            }
        return builder.create()
    }


}
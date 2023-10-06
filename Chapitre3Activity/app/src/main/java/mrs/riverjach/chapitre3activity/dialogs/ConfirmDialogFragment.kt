package mrs.riverjach.chapitre3activity.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class ConfirmDialogFragment : DialogFragment() {
    val TAG = ConfirmDialogFragment::class.java.name
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setMessage("Souhaitez-vous réellement supprimer ces fichiers?")
            .setPositiveButton(
                "Oui"
            ) { _, _ -> Log.i(TAG, "Fichier supprimé") }
            .setNegativeButton("Non merci") { _, _ ->
                Log.i(TAG, "Fichier conservé")
            }
        return builder.create()
    }
}
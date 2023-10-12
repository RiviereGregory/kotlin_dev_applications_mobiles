package mrs.riverjach.chapitre3activity.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import mrs.riverjach.chapitre3activity.R

class ConfirmFileDelete : DialogFragment() {
    val TAG = ConfirmFileDelete::class.java.name
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        builder.setView(inflater.inflate(R.layout.delete_confirmation, null))
            .setPositiveButton(
                "Supprimer"
            ) { _, _ -> Log.i(TAG, "fichier supprimé") }
            .setNegativeButton("Non merci", { _, _ ->
                Log.i(TAG, "fichier conservé")
            })
            .setTitle("contenu supprimé")
        return builder.create()
    }
}
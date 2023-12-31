package mrs.riverjach.blocnote.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import mrs.riverjach.blocnote.R
import mrs.riverjach.blocnote.fragments.ConfirmDeleteNoteDialogFragment
import mrs.riverjach.blocnote.model.Categories
import mrs.riverjach.blocnote.model.Note

class DetailNote : AppCompatActivity(), View.OnClickListener {

    companion object {
        val REQUEST_EDIT_NOTE = 1
        val ACTION_SAVE = "mrs.riverjach.blocnote.activities.ACTION_SAVE"
        val ACTION_DELETE = "mrs.riverjach.blocnote.activities.ACTION_DELETE"
        var categories: List<Categories> = listOf(
            Categories.FAIRE,
            Categories.COURSE,
            Categories.RDV_PRO,
            Categories.RDV_PERSO,
            Categories.URL,
            Categories.CONTACT,
            Categories.LOISIR
        )
    }

    lateinit var note: Note
    lateinit var textViewTitre: TextView
    lateinit var textViewCategorie: TextView
    lateinit var textViewContenu: TextView
    lateinit var rLayout: RelativeLayout
    lateinit var radioGroup: RadioGroup
    var noteIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_note)

        note = intent.getParcelableExtra("note")!!
        noteIndex = intent.getIntExtra("noteindex", -1)
        textViewTitre = findViewById(R.id.titre)
        textViewCategorie = findViewById(R.id.categorie)
        textViewContenu = findViewById(R.id.contenu)
        radioGroup = findViewById(R.id.radiogroup)
        rLayout = findViewById(R.id.layout)
        textViewCategorie.setOnClickListener(this)

        textViewTitre.text = note.titre
        val category = categories[note.cat]
        textViewCategorie.text = category.text
        textViewContenu.text = note.contenu
        rLayout.setBackgroundColor(category.color)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                Toast.makeText(this, getString(R.string.icone_save_cliqu), Toast.LENGTH_SHORT)
                    .show()
                saveNote()
                true
            }

            R.id.action_delete -> {
                showConfirmDeleteDialog()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showConfirmDeleteDialog() {
        val confirmFragment = ConfirmDeleteNoteDialogFragment(note.titre)
        confirmFragment.listenner =
            object : ConfirmDeleteNoteDialogFragment.ConfirmDeleteDialogListenner {
                override fun onDialogPositiveClick() {
                    deleteNote()
                }

                override fun onDialogNegativeClick() {
                    // Nothing
                }
            }
        confirmFragment.show(supportFragmentManager, "confirmDeleteDialog")

    }

    private fun deleteNote() {
        intent = Intent(ACTION_DELETE)
        intent.putExtra("noteindex", noteIndex)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onClick(view: View?) {
        if (view == textViewCategorie) {
            Toast.makeText(this, getString(R.string.textview_cliqu), Toast.LENGTH_SHORT).show()
            radioGroup.visibility = View.VISIBLE
        }
    }

    fun saveNote() {
        note.titre = textViewTitre.text.toString()
        note.contenu = textViewContenu.text.toString()
        when {
            findViewById<RadioButton>(R.id.radio0).isChecked -> note.cat = 0
            findViewById<RadioButton>(R.id.radio1).isChecked -> note.cat = 1
            findViewById<RadioButton>(R.id.radio2).isChecked -> note.cat = 2
            findViewById<RadioButton>(R.id.radio3).isChecked -> note.cat = 3
            findViewById<RadioButton>(R.id.radio4).isChecked -> note.cat = 4
            findViewById<RadioButton>(R.id.radio5).isChecked -> note.cat = 5
            findViewById<RadioButton>(R.id.radio6).isChecked -> note.cat = 6
        }
        intent = Intent(ACTION_SAVE)
        intent.putExtra("note", note as Parcelable)
        intent.putExtra("noteindex", noteIndex)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
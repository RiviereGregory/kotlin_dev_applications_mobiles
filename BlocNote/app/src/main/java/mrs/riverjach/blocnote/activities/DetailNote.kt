package mrs.riverjach.blocnote.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import mrs.riverjach.blocnote.R
import mrs.riverjach.blocnote.adapter.NoteAdapter
import mrs.riverjach.blocnote.model.Note

class DetailNote : AppCompatActivity() {

    companion object {
        var listeCategorie = listOf(
            "A faire",
            "Liste de courses",
            "Rendez-vous pro",
            "Rendez-vous perso",
            "Lien internet",
            "Contact",
            "Loisirs"
        )
    }

    lateinit var note: Note
    lateinit var textViewTitre: TextView
    lateinit var textViewCategorie: TextView
    lateinit var textViewContenu: TextView
    lateinit var rLayout: RelativeLayout
    var noteIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_note)

        note = intent.getParcelableExtra("note")!!
        noteIndex = intent.getIntExtra("noteindex", -1)
        textViewTitre = findViewById(R.id.titre)
        textViewCategorie = findViewById(R.id.categorie)
        textViewContenu = findViewById(R.id.contenu)
        rLayout = findViewById(R.id.layout)

        textViewTitre.text = note.titre
        textViewCategorie.text = listeCategorie[note.cat]
        textViewContenu.text = note.contenu
        rLayout.setBackgroundColor(NoteAdapter.color[note.cat])

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
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
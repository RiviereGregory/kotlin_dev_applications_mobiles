package mrs.riverjach.blocnote.activities

import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import mrs.riverjach.blocnote.R
import mrs.riverjach.blocnote.adapter.NoteAdapter
import mrs.riverjach.blocnote.model.Note

class DetailNote : AppCompatActivity() {

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
        textViewCategorie.text = note.cat.toString()
        textViewContenu.text = note.contenu
        rLayout.setBackgroundColor(NoteAdapter.color[note.cat])

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
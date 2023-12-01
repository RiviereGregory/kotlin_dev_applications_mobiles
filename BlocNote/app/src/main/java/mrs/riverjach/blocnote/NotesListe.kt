package mrs.riverjach.blocnote

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mrs.riverjach.blocnote.activities.DetailNote
import mrs.riverjach.blocnote.adapter.NoteAdapter
import mrs.riverjach.blocnote.model.Note

class MainActivity : ComponentActivity(), View.OnClickListener {
    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listes_notes)
        val fab = findViewById<FloatingActionButton>(R.id.create_note_fab)
        fab.setOnClickListener(this)

        notes = mutableListOf()
        notes.add(Note("Note 1", getString(R.string.j_adore_le_langage_kotlin), 0, ""))
        notes.add(Note("Note 2", getString(R.string.j_adore_le_langage_kotlin), 1, ""))
        notes.add(Note("Note 3", getString(R.string.j_adore_le_langage_kotlin), 2, ""))
        notes.add(Note("Note 4", getString(R.string.j_adore_le_langage_kotlin), 3, ""))
        notes.add(Note("Note 5", getString(R.string.j_adore_le_langage_kotlin), 4, ""))
        notes.add(Note("Note 6", getString(R.string.j_adore_le_langage_kotlin), 5, ""))
        notes.add(Note("Note 7", getString(R.string.j_adore_le_langage_kotlin), 6, ""))
        notes.add(Note("Note 8", getString(R.string.j_adore_le_langage_kotlin), 0, ""))
        notes.add(Note("Note 9", getString(R.string.j_adore_le_langage_kotlin), 1, ""))
        notes.add(Note("Note 10", getString(R.string.j_adore_le_langage_kotlin), 2, ""))
        notes.add(Note("Note 11", getString(R.string.j_adore_le_langage_kotlin), 3, ""))
        notes.add(Note("Note 12", getString(R.string.j_adore_le_langage_kotlin), 4, ""))
        notes.add(Note("Note 13", getString(R.string.j_adore_le_langage_kotlin), 5, ""))
        notes.add(Note("Note 14", getString(R.string.j_adore_le_langage_kotlin), 6, ""))

        val recyclerView = findViewById<RecyclerView>(R.id.liste_notes_recycler_view)
        adapter = NoteAdapter(notes, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onClick(view: View?) {
        if (view?.tag != null) {
            val chaine = view.tag as String
            val chaineList = chaine.split(";")
            val pos = chaineList[1].toInt()
            Toast.makeText(this, "tag : ${pos}", Toast.LENGTH_SHORT).show()

            editNote(pos)
        } else {
            when (view?.id) {
                R.id.create_note_fab -> createNote()
            }
        }
    }

    private fun createNote() {
        editNote(-1)
    }

    private fun editNote(position: Int) {
        val note = if (position < 0) Note() else notes[position]
        val intent = Intent(this, DetailNote::class.java)
        intent.putExtra("note", note)
        intent.putExtra("noteindex", position)
        startActivityForResult(intent, DetailNote.REQUEST_EDIT_NOTE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != Activity.RESULT_OK || data == null) {
            return
        }
        when (requestCode) {
            DetailNote.REQUEST_EDIT_NOTE -> traitementRetour(data)
        }
    }

    private fun traitementRetour(data: Intent) {
        val noteIndex = data.getIntExtra("noteindex", -1)
        val note = data.getParcelableExtra<Note>("note")!!
        saveNote(note, noteIndex)
    }

    private fun saveNote(note: Note, noteIndex: Int) {
        if (noteIndex < 0) {
            notes.add(0, note)
        } else {
            notes[noteIndex] = note
        }
        adapter.notifyDataSetChanged()
    }
}

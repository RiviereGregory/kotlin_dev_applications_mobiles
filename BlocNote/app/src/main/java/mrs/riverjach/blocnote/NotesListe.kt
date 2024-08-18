package mrs.riverjach.blocnote

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mrs.riverjach.blocnote.activities.DetailNote
import mrs.riverjach.blocnote.adapter.NoteAdapter
import mrs.riverjach.blocnote.model.Note
import mrs.riverjach.blocnote.urils.deleteNote
import mrs.riverjach.blocnote.urils.loadNotes
import mrs.riverjach.blocnote.urils.writeNote

class MainActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var notes: MutableList<Note>
    private lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listes_notes)
        val fab = findViewById<FloatingActionButton>(R.id.create_note_fab)
        fab.setOnClickListener(this)

        notes = loadNotes(this)
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
            Toast.makeText(this, "${notes[pos].titre} est en édition", Toast.LENGTH_SHORT).show()

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
        intent.putExtra("note", note as Parcelable)
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

    private fun deleteNote(noteIndex: Int) {
        if (noteIndex < 0) {
            return
        } else {
            val note = notes.removeAt(noteIndex)
            deleteNote(this, note)
            adapter.notifyDataSetChanged()
        }
    }

    private fun traitementRetour(data: Intent) {
        val noteIndex = data.getIntExtra("noteindex", -1)
        val note = data.getParcelableExtra<Note>("note")
        when (data.action) {
            DetailNote.ACTION_DELETE -> {
                deleteNote(noteIndex)
            }

            DetailNote.ACTION_SAVE -> {
                if (note != null) saveNote(note, noteIndex)
            }
        }
    }

    private fun saveNote(note: Note, noteIndex: Int) {
        writeNote(this, note)
        if (noteIndex < 0) {
            notes.add(0, note)
        } else {
            notes[noteIndex] = note
        }
        adapter.notifyDataSetChanged()
    }
}

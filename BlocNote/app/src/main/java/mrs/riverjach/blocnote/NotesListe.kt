package mrs.riverjach.blocnote

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mrs.riverjach.blocnote.activities.DetailNote
import mrs.riverjach.blocnote.adapter.NoteAdapter
import mrs.riverjach.blocnote.model.Note

class MainActivity : ComponentActivity(), View.OnClickListener {
    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listes_notes)

        notes = mutableListOf()
        notes.add(Note("Note 1", "J'adore le langage Kotlin", 0, ""))
        notes.add(Note("Note 2", "J'adore le langage Kotlin", 1, ""))
        notes.add(Note("Note 3", "J'adore le langage Kotlin", 2, ""))
        notes.add(Note("Note 4", "J'adore le langage Kotlin", 3, ""))
        notes.add(Note("Note 5", "J'adore le langage Kotlin", 4, ""))
        notes.add(Note("Note 6", "J'adore le langage Kotlin", 5, ""))
        notes.add(Note("Note 7", "J'adore le langage Kotlin", 6, ""))
        notes.add(Note("Note 8", "J'adore le langage Kotlin", 0, ""))
        notes.add(Note("Note 9", "J'adore le langage Kotlin", 1, ""))
        notes.add(Note("Note 10", "J'adore le langage Kotlin", 2, ""))
        notes.add(Note("Note 11", "J'adore le langage Kotlin", 3, ""))
        notes.add(Note("Note 12", "J'adore le langage Kotlin", 4, ""))
        notes.add(Note("Note 13", "J'adore le langage Kotlin", 5, ""))
        notes.add(Note("Note 14", "J'adore le langage Kotlin", 6, ""))

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
        }
    }

    private fun editNote(position: Int) {
        val intent = Intent(this, DetailNote::class.java)
        intent.putExtra("note", notes[position])
        intent.putExtra("noteindex", position)
        startActivity(intent)
    }
}

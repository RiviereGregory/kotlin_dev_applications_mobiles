package mrs.riverjach.blocnote.urils

import android.content.Context
import android.text.TextUtils
import mrs.riverjach.blocnote.model.Note
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.UUID

fun writeNote(context: Context, note: Note) {
    if (TextUtils.isEmpty(note.filename)) {
        note.filename = UUID.randomUUID().toString() + ".note"
    }
    val fileOutPut = context.openFileOutput(note.filename, Context.MODE_PRIVATE)
    val outputStream = ObjectOutputStream(fileOutPut)
    outputStream.writeObject(note)
    outputStream.close()
}

private fun loadNote(context: Context, filename: String): Note {
    val fileInput = context.openFileInput(filename)
    val inputStream = ObjectInputStream(fileInput)
    val note = inputStream.readObject() as Note
    inputStream.close()
    return note
}

fun loadNotes(context: Context): MutableList<Note> {
    val notes = mutableListOf<Note>()
    val noteDir = context.filesDir
    for (filename in noteDir.list()) {
        if (filename.contains(".note")) {
            val note = loadNote(context, filename)
            notes.add(note)
        }
    }
    return notes
}

fun deleteNote(context: Context, note: Note) {
    context.deleteFile(note.filename)
}
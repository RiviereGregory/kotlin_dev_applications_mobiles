package mrs.riverjach.blocnote.model

import mrs.riverjach.blocnote.adapter.NoteAdapter

enum class Categories(val text: String, val color: Int) {
    FAIRE("A faire", NoteAdapter.color[0]),
    COURSE("Liste de courses", NoteAdapter.color[1]),
    RDV_PRO("Rendez-vous pro", NoteAdapter.color[2]),
    RDV_PERSO("Rendez-vous perso", NoteAdapter.color[3]),
    URL("Lien internet", NoteAdapter.color[4]),
    CONTACT("Contact", NoteAdapter.color[5]),
    LOISIR("Loisirs", NoteAdapter.color[6])
}
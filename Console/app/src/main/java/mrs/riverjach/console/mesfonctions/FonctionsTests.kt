package mrs.riverjach.console.mesfonctions

var age = 10
var name = "Tom"
    private set
private var adresse = "12 rue du moulin 75000 PARIS"

fun changerNom(newName: String) {
    name = newName
}

private fun afficherAdresse() = println(adresse)
package mrs.riverjach.console.mesclasses.abstraite

class GrosseCaisse() : Instrument("Grosse Caisse") {
    override fun play(note: String, volume: Int) {
        println("BOUM volume $volume")
    }
}
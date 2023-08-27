package mrs.riverjach.console.mesclasses.abstraite

class Xylophone() : Instrument("Xylophone") {
    override fun play(note: String, volume: Int) {
        println("Ding note : $note , volume : $volume")
    }
}
package mrs.riverjach.console.mesclasses.abstraite

abstract class Instrument(val name: String) {
    abstract fun play(note: String, volume: Int)
}
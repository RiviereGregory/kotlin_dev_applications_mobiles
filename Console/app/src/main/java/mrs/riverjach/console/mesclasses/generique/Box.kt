package mrs.riverjach.console.mesclasses.generique

class Box<T>(var value: T) {
    fun set(v: T) {
        value = v
    }

    fun get(): T {
        return value
    }
}
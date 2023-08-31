package mrs.riverjach.console.mesclasses.nestedclass

class Palette(val nombre: Int) {
    val poids = arrayOfNulls<Item1>(nombre)
    val volume = arrayOfNulls<Item2>(nombre)

    fun showPalette(i: Int) {
        println("Palette n° $i : Poids : ${poids[i]?.poids} kg - Volume : ${volume[i]?.volume}")
    }

    class Item1(val poids: Int) {
    }

    class Item2(val volume: Int) {

    }
}
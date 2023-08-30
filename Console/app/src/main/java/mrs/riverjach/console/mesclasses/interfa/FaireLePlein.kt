package mrs.riverjach.console.mesclasses.interfa

interface FaireLePlein {
    var niveau: Int
    fun FaireLePlein() {
        niveau = 100
        println("J'ai fait le plein de carburant")
        println("Mon niveau de carburant est à $niveau %")
    }
}
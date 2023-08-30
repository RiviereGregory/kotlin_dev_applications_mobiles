package mrs.riverjach.console.mesclasses.interfa

class Avion : Vehicule("", 0), Rouler, Voler, FaireLePlein {
    override var vitesse: Int = 0
    override var niveau: Int = 0
    override var altitude: Int = 0
}
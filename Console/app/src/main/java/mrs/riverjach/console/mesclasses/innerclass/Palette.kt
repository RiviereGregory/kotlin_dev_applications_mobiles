package mrs.riverjach.console.mesclasses.innerclass

class Palette(val nb: Int) {
    inner class Caisse(var nbCaisse: Int) {
        init {
            if (nbCaisse > 12) nbCaisse = 12 else nbCaisse
        }

        inner class Produit() {
            var nbProduit = nb * nbCaisse * 50
        }
    }
}
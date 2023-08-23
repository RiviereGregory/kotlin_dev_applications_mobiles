package mrs.riverjach.console.mesclasses.heritage

// open permet l'héritage
open class Produit(
    var nom: String,
    var code: Long,
    var prix: Double,
    var qteStock: Int,
    var qteAlerte: Int,
    var alerteStock: Boolean
) {
    fun alerte() {
        if (qteStock <= qteAlerte) alerteStock = true
    }

    fun visualiser() {
        println("Nom : ${nom}; Code : ${code}; prix : ${prix} €")
        println("Stock: ${qteStock} ; Commande fournisseur à effectuer : ${alerteStock}")
    }

    fun acheter(qte: Int) {
        if (qte <= qteStock) {
            qteStock -= qte
            if (qteStock <= qteAlerte) {
                alerteStock = true
                println("Stock critique atteint : Article à commander")
            }
        } else {
            println("Stock insuffisant pour cet achat/")
        }
    }

    fun livrer(qteLivraison: Int) {
        qteStock += qteLivraison
    }
}
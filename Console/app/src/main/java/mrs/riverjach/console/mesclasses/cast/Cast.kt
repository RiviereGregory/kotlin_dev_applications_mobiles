package mrs.riverjach.console.mesclasses.cast

fun demoSmartCast(obj: Any) {
    when (obj) {
        is Int -> println(obj + 1)
        is String -> println("longueur " + obj.length)
        is IntArray -> println(obj.sum())
    }
}

fun longueurStringUnsafeCast(obj: Any) {
    if (obj is String) {
        print("longueur de la chaine : ")
        println(obj.length)
    } else {
        println("n'est pas de type String")
    }
}

fun longueurStringSafeCast(obj: Any?) {
    if (obj is String) {
        print("longueur de la chaine : ")
        println(obj.length)
    } else {
        println("n'est pas de type String")
    }
}

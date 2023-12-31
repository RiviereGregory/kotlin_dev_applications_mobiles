package mrs.riverjach.allerplusloinaveckotlin.utils

fun filterArrayInt(tabInt: Array<Int>, param: (Int) -> Boolean): Array<Int> {
    val filterTab = mutableListOf<Int>()
    for (i in tabInt) {
        if (param(i)) {
            filterTab.add(i)
        }
    }
    return filterTab.toTypedArray()
}

fun filterPositif(n: Int) = n >= 0

fun filterPair(n: Int) = n % 2 == 0

fun filterMultiple3(n: Int) = n % 3 == 0

fun filterArrayIntMultiplek(tabInt: Array<Int>, k: Int, param: (Int, Int) -> Boolean): Array<Int> {
    val filterTab = mutableListOf<Int>()
    for (i in tabInt) {
        if (param(k, i)) {
            filterTab.add(i)
        }
    }
    return filterTab.toTypedArray()
}

fun filterMulitple(k: Int, n: Int) = n % k == 0

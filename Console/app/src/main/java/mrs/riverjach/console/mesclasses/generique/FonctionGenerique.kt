package mrs.riverjach.console.mesclasses.generique

fun <T> demo(array: Array<T>): String {
    var separator = ""
    val sb = StringBuilder()
    for (i in array.indices) {
        sb.append(separator)
        sb.append(array[i])
        separator = ";"
    }
    return sb.toString()
}
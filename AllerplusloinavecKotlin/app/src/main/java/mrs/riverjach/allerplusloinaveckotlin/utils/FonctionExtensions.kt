package mrs.riverjach.allerplusloinaveckotlin.utils

import android.view.View

fun Int.isEvent(): Boolean {
    return this % 2 == 0
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun View.switch() {
    if (this.visibility == View.VISIBLE) {
        this.visibility = View.INVISIBLE
    } else {
        this.visibility = View.VISIBLE
    }

}
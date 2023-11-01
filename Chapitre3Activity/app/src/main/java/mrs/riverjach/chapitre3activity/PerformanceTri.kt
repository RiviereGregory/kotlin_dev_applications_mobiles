package mrs.riverjach.chapitre3activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class PerformanceTri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_performance_tri)

        val tabInt = Array<Int>(10000) { i -> Random.nextInt(0, 1000) }

        findViewById<Button>(R.id.tri_selection).setOnClickListener {
            triSelection(tabInt)
        }
        findViewById<Button>(R.id.tri_bulle).setOnClickListener {
            triBulle(tabInt)
        }
        findViewById<Button>(R.id.tri_methode_sort).setOnClickListener {
            tabInt.sort()
        }

    }

    fun triSelection(tab: Array<Int>): Array<Int> {
        var min: Int
        var temp: Int
        for (i in 0..tab.size - 2) {
            min = i
            for (j in i + 1..tab.size - 1) {
                if (tab[j] < tab[min]) {
                    min = j
                }
            }
            if (min != i) {
                temp = tab[i]
                tab[i] = tab[min]
                tab[min] = temp
            }
        }
        return tab
    }

    fun triBulle(tab: Array<Int>): Array<Int> {
        var temp: Int
        for (i in tab.size - 1..1) {
            for (j in 0..i - 1) {
                if (tab[j + 1] < tab[j]) {
                    temp = tab[j]
                    tab[j] = tab[j + 1]
                    tab[j + 1] = temp
                }
            }
        }
        return tab
    }

}
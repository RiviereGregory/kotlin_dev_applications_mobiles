package mrs.riverjach.chapitre3activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TomAndLola : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tom_and_lola)
        val buttonLancer: Button = findViewById(R.id.lancer)
        buttonLancer.setOnClickListener {
            score()
        }
    }

    private fun score() {
        var scoreTom = 0
        var scoreLola = 0
        var numberRound = 0
        val round: TextView = findViewById(R.id.numberRound)
        val tom: TextView = findViewById(R.id.scoreTom)
        val lola: TextView = findViewById(R.id.scoreLola)
        for (i in 0..99) {
            val sumDies: Int = lancer()
            when {
                sumDies < 6 -> scoreTom++
                sumDies == 6 -> scoreTom += 5
                sumDies == 7 -> scoreLola += 4
                else -> scoreLola++
            }
            numberRound++
            round.text = numberRound.toString()
            tom.text = scoreTom.toString()
            lola.text = scoreLola.toString()
        }
        val winner: TextView = findViewById(R.id.winner)
        when {
            scoreTom > scoreLola -> winner.text = getString(R.string.tom_a_gagn)
            scoreLola > scoreTom -> winner.text = getString(R.string.lola_a_gagn)
            else -> winner.text = getString(R.string.egalit)
        }

    }


    private fun lancer(): Int {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val de1 = numbers.random()
        val de2 = numbers.random()
        val sum = de1 + de2
        val deOne: TextView = findViewById(R.id.de1)
        val deTwo: TextView = findViewById(R.id.de2)
        val sumTwoDie: TextView = findViewById(R.id.totalDe)
        deOne.text = de1.toString()
        deTwo.text = de2.toString()
        sumTwoDie.text = sum.toString()
        return sum
    }
}
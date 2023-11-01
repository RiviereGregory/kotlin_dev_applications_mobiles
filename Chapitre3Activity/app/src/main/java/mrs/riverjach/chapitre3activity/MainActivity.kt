package mrs.riverjach.chapitre3activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import mrs.riverjach.chapitre3activity.dialogs.ConfirmDialogFragment
import mrs.riverjach.chapitre3activity.dialogs.ConfirmFileDelete
import mrs.riverjach.chapitre3activity.metier.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // indique que la toolbar peut accueillir un actionMenu
        val toolBar: Toolbar = findViewById(R.id.mytoolbar)
        setSupportActionBar(toolBar)

        val button: Button = findViewById(R.id.startButton)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val user = User("Tom", 16)
        button.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
        button1.setOnClickListener {
            val intent = Intent(this, DimensionUnites::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, LinearLayoutSample::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, LinearLayoutSampleMozaic::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, RelativeLayoutSample::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this, RelativeLayoutSample2::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this, ComposantGraphics::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            val fragment = ConfirmDialogFragment()
            fragment.listener = object :
                ConfirmDialogFragment.ConfirmDeleteListener {
                override fun onDialogPositiveClick() {
                    val fragment = ConfirmFileDelete()
                    fragment.show(supportFragmentManager, "ConfirmFileDelete")
                }

                override fun onDialogNegativeClick() {
                    // Nothing
                }
            }
            fragment.show(supportFragmentManager, "confirm")
        }
        button8.setOnClickListener {
            val intent = Intent(this, RecyclerViewSample::class.java)
            startActivity(intent)
        }
        button9.setOnClickListener {
            val intent = Intent(this, TomAndLola::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_bin -> {
                Toast.makeText(this, "Corbeille", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_camera -> {
                Toast.makeText(this, "Camera", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_folder -> {
                Toast.makeText(this, "Dossier", Toast.LENGTH_SHORT).show()
                true
            }

            else -> false
        }
    }
}
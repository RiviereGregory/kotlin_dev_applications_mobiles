package mrs.riverjach.allerplusloinaveckotlin.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrs.riverjach.allerplusloinaveckotlin.R
import mrs.riverjach.allerplusloinaveckotlin.fragments.GreyDarkFragment
import mrs.riverjach.allerplusloinaveckotlin.fragments.GreyLightFragment

class FrameLayoutActivity : AppCompatActivity(), GreyDarkFragment.GreyDarkFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_layout_activity)

        val greyDarkFragment = GreyDarkFragment()
        greyDarkFragment.listener = this
        supportFragmentManager.beginTransaction()
            .add(R.id.container, greyDarkFragment)
            .commit()
    }

    override fun onClick() {
        val greyLightFragment = GreyLightFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, greyLightFragment)
            .addToBackStack(null) // Permet de revenir au fragment précedent
            .commit()
    }
}
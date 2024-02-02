package mrs.riverjach.allerplusloinaveckotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import mrs.riverjach.allerplusloinaveckotlin.R

class GreyDarkFragment : Fragment() {

    interface GreyDarkFragmentListener {
        fun onClick()
    }

    var listener: GreyDarkFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_greydark, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            listener?.onClick()
        }
        return view
    }
}
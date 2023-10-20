package mrs.riverjach.chapitre3activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mrs.riverjach.chapitre3activity.adapter.UserAdapter

class RecyclerViewSample : AppCompatActivity() {
    var names = arrayOf<String>(
        "aa",
        "bb",
        "cc",
        "dd",
        "ee",
        "ff",
        "gg",
        "hh",
        "ii",
        "jj",
        "KK",
        "ll",
        "mm",
        "nn",
        "oo",
        "pp",
        "qq",
        "rr",
        "ss",
        "tt",
        "uu",
        "vv",
        "ww",
        "xx",
        "yy",
        "zz"
    )
    var tels = arrayOf<String>(
        "0102030405",
        "0202030405",
        "0302030405",
        "0104030405",
        "0152030405",
        "0133030405",
        "0155030405",
        "0102660405",
        "0102030488",
        "0102039905",
        "0102030405",
        "0202030405",
        "0302030405",
        "0104030405",
        "0152030405",
        "0133030405",
        "0155030405",
        "0102660405",
        "0102030488",
        "0102039905",
        "0102030405",
        "0202030405",
        "0302030405",
        "0104030405",
        "0152030405",
        "0133030405",
        "0155030405",
        "0102660405",
        "0102030488",
        "0102039905"
    )
    val adapter = UserAdapter(names, tels)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_sample)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
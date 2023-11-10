package mrs.riverjach.blocnote.adapter

import android.graphics.Color.rgb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import mrs.riverjach.blocnote.R
import mrs.riverjach.blocnote.model.Note

class NoteAdapter(
    val notes: List<Note>,
    val itemClickListener: View.OnClickListener
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    val color0 = rgb(211, 248, 226)
    val color1 = rgb(228, 193, 249)
    val color2 = rgb(246, 148, 193)
    val color3 = rgb(237, 231, 177)
    val color4 = rgb(71, 152, 41)
    val color5 = rgb(253, 225, 0)
    val color6 = rgb(240, 240, 240)
    val color = arrayOf(color0, color1, color2, color3, color4, color5, color6)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView1 = itemView.findViewById<CardView>(R.id.card_view1)
        val titre1 = cardView1.findViewById<TextView>(R.id.titre1)
        val contenu1 = cardView1.findViewById<TextView>(R.id.contenu1)
        val layout1 = cardView1.findViewById<RelativeLayout>(R.id.layout1)
        val cardView2 = itemView.findViewById<CardView>(R.id.card_view2)
        val titre2 = cardView2.findViewById<TextView>(R.id.titre2)
        val contenu2 = cardView2.findViewById<TextView>(R.id.contenu2)
        val layout2 = cardView2.findViewById<RelativeLayout>(R.id.layout2)
        val cardView3 = itemView.findViewById<CardView>(R.id.card_view3)
        val titre3 = cardView3.findViewById<TextView>(R.id.titre3)
        val contenu3 = cardView3.findViewById<TextView>(R.id.contenu3)
        val layout3 = cardView3.findViewById<RelativeLayout>(R.id.layout3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewitem = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val position1 = 3 * position
        val position2 = 3 * position + 1
        val position3 = 3 * position + 2

        if (position1 < notes.size) {
            val titre1 = notes[position1].titre
            val contenu1 = notes[position1].contenu
            val filename1 = notes[position1].filename
            val cat1 = notes[position1].cat
            holder.titre1.text = titre1
            holder.contenu1.text = contenu1
            holder.cardView1.setOnClickListener(itemClickListener)
            holder.cardView1.tag = "${filename1};$position1"
            holder.layout1.setBackgroundColor(color[cat1])
            holder.cardView1.visibility = View.VISIBLE
        }
        if (position2 < notes.size) {
            val titre2 = notes[position2].titre
            val contenu2 = notes[position2].contenu
            val filename2 = notes[position2].filename
            val cat2 = notes[position2].cat
            holder.titre2.text = titre2
            holder.contenu2.text = contenu2
            holder.cardView2.setOnClickListener(itemClickListener)
            holder.cardView2.tag = "${filename2};$position2"
            holder.layout2.setBackgroundColor(color[cat2])
            holder.cardView2.visibility = View.VISIBLE
        } else {
            holder.titre2.text = ""
            holder.contenu2.text = ""
            holder.cardView2.tag = ""
            holder.cardView2.visibility = View.INVISIBLE
        }
        if (position3 < notes.size) {
            val titre3 = notes[position3].titre
            val contenu3 = notes[position3].contenu
            val filename3 = notes[position3].filename
            val cat3 = notes[position3].cat
            holder.titre3.text = titre3
            holder.contenu3.text = contenu3
            holder.cardView3.setOnClickListener(itemClickListener)
            holder.cardView3.tag = "${filename3};$position3"
            holder.layout3.setBackgroundColor(color[cat3])
            holder.cardView3.visibility = View.VISIBLE
        } else {
            holder.titre3.text = ""
            holder.contenu3.text = ""
            holder.cardView3.tag = ""
            holder.cardView3.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return if (notes.size % 3 == 0) notes.size / 3 else notes.size / 3 + 1
    }

}
package mrs.riverjach.chapitre3activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import mrs.riverjach.chapitre3activity.R

class UserAdapter(
    val names: Array<String>,
    val tels: Array<String>,
    val itemClickListener: View.OnClickListener
) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val name = itemView.findViewById<TextView>(R.id.name)
        val tel = itemView.findViewById<TextView>(R.id.tel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewitem = inflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = names[position]
        val tel = tels[position]
        holder.icon.setImageResource(R.drawable.chat)
        holder.name.text = name
        holder.tel.text = tel
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
    }

    override fun getItemCount(): Int {
        return names.size
    }

}
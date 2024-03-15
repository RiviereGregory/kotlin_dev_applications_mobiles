package mrs.riverjach.meteo.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import mrs.riverjach.meteo.R

class CityAdapter(
    private val cities: List<City>,
    private val cityClickListener: CityItemListener
) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>(), View.OnClickListener {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView1: CardView = itemView.findViewById(R.id.card_view1)
        val cardView2: CardView = itemView.findViewById(R.id.card_view2)
        val textView1: TextView = itemView.findViewById(R.id.ville1)
        val textView2: TextView = itemView.findViewById(R.id.ville2)
        val deleteView1: View = itemView.findViewById(R.id.image_view_bin1)
        val deleteView2: View = itemView.findViewById(R.id.image_view_bin2)
    }

    interface CityItemListener {
        fun onCitySelected(city: City)
        fun onCityDeleted(city: City)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return if (cities.size % 2 == 0) cities.size / 2 else cities.size / 2 + 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (2 * position < cities.size) {
            holder.textView1.text = cities[2 * position].name
            holder.cardView1.setOnClickListener(this)
            holder.cardView1.tag = cities[2 * position]
            holder.deleteView1.tag = cities[2 * position]
            holder.deleteView1.setOnClickListener(this)
        }
        if (2 * position + 1 < cities.size) {
            holder.textView2.text = cities[2 * position + 1].name
            holder.cardView2.setOnClickListener(this)
            holder.cardView2.tag = cities[2 * position + 1]
            holder.cardView2.visibility = View.VISIBLE
            holder.deleteView2.tag = cities[2 * position + 1]
            holder.deleteView2.setOnClickListener(this)
        } else {
            holder.cardView2.visibility = View.INVISIBLE
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.card_view1 -> cityClickListener.onCitySelected(view.tag as City)
            R.id.card_view2 -> cityClickListener.onCitySelected(view.tag as City)
            R.id.image_view_bin1 -> cityClickListener.onCityDeleted(view.tag as City)
            R.id.image_view_bin2 -> cityClickListener.onCityDeleted(view.tag as City)
        }
    }


}
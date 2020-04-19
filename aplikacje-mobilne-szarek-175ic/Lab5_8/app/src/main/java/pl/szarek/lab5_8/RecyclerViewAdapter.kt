package pl.szarek.lab5_8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.szarek.lab5_8.database.entity.Language

class RecyclerViewAdapter(
    private val items: List<Language>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataTextView.text = items[position].name
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dataTextView: TextView

        init {
            dataTextView = view.findViewById(R.id.data_text_view)
        }
    }
}
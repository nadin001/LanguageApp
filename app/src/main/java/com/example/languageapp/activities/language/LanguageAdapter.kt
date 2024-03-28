package com.example.languageapp.activities.language

import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.languageapp.R
import com.example.languageapp.R.layout.item_language_button
import com.example.languageapp.activities.language.LanguageAdapter.ViewHolder

class LanguageAdapter(
    private val itemList: List<LanguageItem>,
    private val itemClickListener: (Int) -> Unit,
) : Adapter<ViewHolder>() {

    class ViewHolder(itemView: View, clickListener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.btnLanguage)
        init {
            button.setOnClickListener {
                clickListener(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = from(parent.context).inflate(item_language_button, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.button.text = currentItem.name
        holder.button.isSelected = currentItem.isSelectActivity
    }

    override fun getItemCount(): Int = itemList.size
}
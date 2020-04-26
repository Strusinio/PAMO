package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class RecipeAdapter internal constructor(items: List<RecipeItem?>?) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    private val items: List<RecipeItem?> = ArrayList<Any?>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_receipe, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val img: ImageView
        private val title: TextView
        private val content: TextView
        fun bind(recipeItem: RecipeItem?) {
            img.setImageResource(recipeItem.getImageId())
            title.text = recipeItem.getTitle()
            content.text = recipeItem.getContent()
        }

        init {
            img = itemView.findViewById(R.id.itemRecipeImg)
            title = itemView.findViewById(R.id.itemRecipeTitleTxt)
            content = itemView.findViewById(R.id.itemRecipeContentTxt)
        }
    }

    init {
        this.items.addAll(items)
    }
}
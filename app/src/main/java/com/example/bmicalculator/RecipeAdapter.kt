package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_receipe.view.*
import java.util.*

class RecipeAdapter internal constructor(items: List<RecipeItem>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    private val items: MutableList<RecipeItem> = ArrayList()
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

        fun bind(recipeItem: RecipeItem) {
            itemView.itemRecipeImg.setImageResource(recipeItem.imageId)
            itemView.itemRecipeTitleTxt.text = recipeItem.title
            itemView.itemRecipeContentTxt.text = recipeItem.content
        }
    }

    init {
        this.items.addAll(items)
    }
}
package com.example.bmicalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private final List<RecipeItem> items = new ArrayList();

    RecipeAdapter(List<RecipeItem> items) {
        this.items.addAll(items);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;
        private TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.itemRecipeImg);
            title = itemView.findViewById(R.id.itemRecipeTitleTxt);
            content = itemView.findViewById(R.id.itemRecipeContentTxt);
        }

        public void bind(RecipeItem recipeItem) {
            img.setImageResource(recipeItem.getImageId());
            title.setText(recipeItem.getTitle());
            content.setText(recipeItem.getContent());
        }
    }

}

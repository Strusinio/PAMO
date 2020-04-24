package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Recipe extends AppCompatActivity {
    private Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        EBMIResult result = (EBMIResult) getIntent().getSerializableExtra("arg_bmi");


        // BTN initialize
        backToMain = findViewById(R.id.recipe_back);
        backToMain.setOnClickListener(v -> finish());

        initRecipes(result);
    }

    private void initRecipes(EBMIResult result) {
        RecyclerView rv = findViewById(R.id.recipes);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecipeAdapter(createRecipes(result)));
    }

    private List<RecipeItem> createRecipes(EBMIResult state) {

        List<RecipeItem> result = new ArrayList<>();
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));
        result.add(new RecipeItem(R.drawable.ic_launcher_background, state.name(), "test content"));

        return result;
    }

}

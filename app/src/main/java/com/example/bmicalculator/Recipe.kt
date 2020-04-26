package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Recipe : AppCompatActivity() {
    private var backToMain: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe)
        val result = intent.getSerializableExtra("arg_bmi") as EBMIResult
        // BTN initialize
        backToMain = findViewById(R.id.recipe_back)
        backToMain.setOnClickListener(View.OnClickListener { v: View? -> finish() })
        initRecipes(result)
    }

    private fun initRecipes(result: EBMIResult) {
        val rv = findViewById<RecyclerView>(R.id.recipes)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = RecipeAdapter(createRecipes(result))
    }

    private fun createRecipes(state: EBMIResult): List<RecipeItem?> {
        val result: MutableList<RecipeItem?> = ArrayList()
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        result.add(RecipeItem(R.drawable.ic_launcher_background, state.name, "test content"))
        return result
    }
}
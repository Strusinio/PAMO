package com.example.bmicalculator;

public class RecipeItem {
    private final int imageId;

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    private final String title;
    private final String content;

    public RecipeItem(int imageId, String title, String content) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
    }
}

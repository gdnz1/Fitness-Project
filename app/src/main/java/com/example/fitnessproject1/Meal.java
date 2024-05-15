package com.example.fitnessproject1;

public class Meal {
    private String name;
    private int imageResourceId;
    private int calories;
    private boolean isSelected;



    public Meal() {

    }

    public Meal(String name, int imageResourceId, int calories) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.calories = calories;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}

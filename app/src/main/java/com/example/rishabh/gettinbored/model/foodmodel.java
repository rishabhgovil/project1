package com.example.rishabh.gettinbored.model;



import java.util.List;

public class foodmodel {
    String name;
    String price;
    String description;
    String calories;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCalories() {
        return calories;
    }

    public foodmodel(String name, String price, String description, String calories) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }
}

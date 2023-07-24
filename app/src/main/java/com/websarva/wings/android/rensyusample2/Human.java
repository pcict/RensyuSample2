package com.websarva.wings.android.rensyusample2;


import androidx.annotation.NonNull;

public class Human {
    private String name;
    private double height;
    private double weight;

    public Human(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    private double caslcBMI(){
        return weight / Math.pow(height / 100, 2);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%sさんのBMIは%.2fです。",name, caslcBMI());
    }
}

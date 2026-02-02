package edu.ucsd.spendingtracker.model;

public enum Category {
    FOOD("#FFD1DC"), TRANSPORT("#BCE29E"), ENTERTAINMENT("#B3E5FC"),
    UTILITIES("#FFF9C4"), OTHER("#E1BEE7");

    public final String color;

    Category(String color) {
        this.color = color;
    }
}

package com.model.product;

public class Category {
    private String category;
    private int id;
    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public Category(String category, int id) {
        this.category = category;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

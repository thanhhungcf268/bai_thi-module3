package com.model.product;

public class Product {
    private int id;
    private String name;
    private double price;
    private int soL;
    private String color;
    private String moTa;
    private String category;

    public Product() {
    }

    public Product(int id, String name, double price, int soL, String color, String moTa,String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.soL = soL;
        this.color = color;
        this.moTa = moTa;
        this.category = category;
    }

    public Product(String name, double price, int soL, String color, String moTa) {
        this.name = name;
        this.price = price;
        this.soL = soL;
        this.color = color;
        this.moTa = moTa;
    }

    public Product(String name, double price, int soL, String color, String moTa, String id_category) {
        this.name = name;
        this.price = price;
        this.soL = soL;
        this.color = color;
        this.moTa = moTa;
        this.category = id_category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSoL() {
        return soL;
    }

    public void setSoL(int soL) {
        this.soL = soL;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}

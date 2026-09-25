package com.shunn2.springaireview.product;

public class Product {

    private final Long id;
    private final String name;
    private final String brand;
    private final String category;
    private final int price;


    public Product(Long id, String name, String brand, String category, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }
}

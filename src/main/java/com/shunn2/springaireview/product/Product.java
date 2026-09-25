package com.shunn2.springaireview.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id // 이 필드가 기본 키(각 행을 구분하는 번호)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호는 DB가 자동으로 매긴다
    private Long id;

    private String name;
    private String brand;
    private String category;
    private int price;

    // JPA가 DB에서 꺼낸 데이터로 객체를 만들 때 쓰는 빈 생성자 (우리가 직접 쓰지는 않는다)
    protected Product() {
    }

    public Product(String name, String brand, String category, int price) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
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

    public int getPrice() {
        return price;
    }
}

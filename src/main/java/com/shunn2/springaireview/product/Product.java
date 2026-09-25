package com.shunn2.springaireview.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA용 빈 생성자 protected Product() { } 를 만들어 준다
public class Product {
    @Id // 이 필드가 기본 키(각 행을 구분하는 번호)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호는 DB가 자동으로 매긴다
    private Long id;

    private String name;
    private String brand;
    private String category;
    private int price;

    public Product(String name, String brand, String category, int price) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }
}

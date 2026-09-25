package com.shunn2.springaireview.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product(1L, "수분 진정 토너", "그린데이", "스킨케어", 18000),
            new Product(2L, "데일리 선크림 SPF50+", "선라이트", "선케어", 22000),
            new Product(3L, "약산성 클렌징폼", "모이스처랩", "클렌징", 12000)
    );

    public List<Product> findAll() {
        return products;
    }

    public Product findById(Long id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.category().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }
}

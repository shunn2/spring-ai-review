package com.shunn2.springaireview.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findAll() {
        return toResponses(productRepository.findAll());
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null; // 6단계에서 예외 처리로 바꾼다
        }
        return ProductResponse.from(product);
    }

    public List<ProductResponse> findByCategory(String category) {
        return toResponses(productRepository.findByCategory(category));
    }

    public List<ProductResponse> findByBrand(String brand) {
        return toResponses(productRepository.findByBrand(brand));
    }

    private List<ProductResponse> toResponses(List<Product> products) {
        List<ProductResponse> result = new ArrayList<>();
        for (Product product : products) {
            result.add(ProductResponse.from(product));
        }
        return result;
    }
}

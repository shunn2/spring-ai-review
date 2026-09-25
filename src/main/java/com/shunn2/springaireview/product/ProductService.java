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

    // 검색 조건으로 상품 목록을 찾는다. 조건을 하나도 안 보내면 전체 목록
    public List<ProductResponse> search(ProductSearchCondition condition) {
        return toResponses(productRepository.findAll(ProductSpecs.search(condition)));
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null; // 7단계에서 예외 처리로 바꾼다
        }
        return ProductResponse.from(product);
    }

    private List<ProductResponse> toResponses(List<Product> products) {
        List<ProductResponse> result = new ArrayList<>();
        for (Product product : products) {
            result.add(ProductResponse.from(product));
        }
        return result;
    }
}

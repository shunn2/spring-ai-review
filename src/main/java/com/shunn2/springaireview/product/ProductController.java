package com.shunn2.springaireview.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 검색 조건을 @RequestParam 여러 개 대신 DTO 하나로 받는다
    // 예: /products?category=스킨케어&brand=그린데이&minPrice=10000&maxPrice=20000&keyword=토너
    @GetMapping("/products")
    public List<ProductResponse> getProducts(ProductSearchCondition condition) {
        return productService.search(condition);
    }

    @GetMapping("/products/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }
}

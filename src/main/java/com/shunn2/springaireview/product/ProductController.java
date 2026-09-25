package com.shunn2.springaireview.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts(@RequestParam(required = false) String category,
                                             @RequestParam(required = false) String brand) {
        // 카테고리를 보냈으면 카테고리로 거른다
        if (category != null) {
            return productService.findByCategory(category);
        }
        // 브랜드를 보냈으면 브랜드로 거른다
        if (brand != null) {
            return productService.findByBrand(brand);
        }
        // 둘 다 안 보냈으면 전체 목록
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }
}

package com.shunn2.springaireview.product;

// 상품 검색 조건을 담는 상자. ?category=스킨케어&minPrice=15000 처럼 보낸 값만 채워지고, 안 보낸 값은 null
// 가격은 null(안 보냄)을 표현해야 해서 int가 아니라 Integer를 쓴다
public record ProductSearchCondition(String category, String brand,
                                     Integer minPrice, Integer maxPrice, String keyword) {
}

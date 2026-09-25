package com.shunn2.springaireview.product;

// record: 괄호 안에 적은 컴포넌트대로 필드, 생성자, 값 꺼내는 메서드(id(), name() ...)를 Java가 자동으로 만든다
public record ProductResponse(Long id, String name, String brand, String category, int price) {

    // Entity → DTO 변환. ProductResponse.from(productResponse) 로 부른다
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getCategory(),
                product.getPrice()
        );
    }
}

package com.shunn2.springaireview.product;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

// 검색 조건(ProductSearchCondition)을 보고 where 절 조각(Specification)을 만든다
public class ProductSpecs {

    public static Specification<Product> search(ProductSearchCondition condition) {
        // where 조건 조각을 모을 목록. 보낸 조건만 추가한다
        List<Specification<Product>> specs = new ArrayList<>();

        // (root, query, cb) -> ... : 람다(이름 없는 짧은 메서드). root = Product, cb = 조건을 만드는 도구
        if (condition.category() != null) {
            specs.add((root, query, cb) -> cb.equal(root.get("category"), condition.category()));             // category = ?
        }
        if (condition.brand() != null) {
            specs.add((root, query, cb) -> cb.equal(root.get("brand"), condition.brand()));                   // brand = ?
        }
        if (condition.minPrice() != null) {
            specs.add((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), condition.minPrice())); // price >= ?
        }
        if (condition.maxPrice() != null) {
            specs.add((root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), condition.maxPrice()));    // price <= ?
        }
        if (condition.keyword() != null) {
            specs.add((root, query, cb) -> cb.like(root.get("name"), "%" + condition.keyword() + "%"));      // name like %?%
        }

        // 모은 조각을 전부 and로 잇는다. 하나도 없으면 조건 없음(전체 조회)
        return Specification.allOf(specs);
    }
}

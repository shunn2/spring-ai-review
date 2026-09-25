package com.shunn2.springaireview.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

// JpaSpecificationExecutor를 물려받으면 findAll(Specification) 으로 동적 쿼리를 실행할 수 있다
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    // 쿼리 메서드 연습용. 지금 /products는 Specification을 쓰고 있어서 이 두 메서드는 호출되지 않는다
    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);
}

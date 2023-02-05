package com.example.quanlysieuthi.repository;

import com.example.quanlysieuthi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p WHERE p.name_product = :name", nativeQuery = true)
    List<Product> findByNameProduct(String name);

    @Query(value = "SELECT * FROM product WHERE product_price BETWEEN :minProductPrice AND :maxProductPrice ", nativeQuery = true)
    List<Product> findByProductPrice(Long minProductPrice, Long maxProductPrice);

    @Query(value = "SELECT MAX(product_price) FROM product", nativeQuery = true)
    Long findMaxProductPrice();
}

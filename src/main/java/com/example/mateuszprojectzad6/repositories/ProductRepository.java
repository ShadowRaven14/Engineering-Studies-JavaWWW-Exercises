package com.example.mateuszprojectzad6.repositories;

import com.example.mateuszprojectzad6.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}

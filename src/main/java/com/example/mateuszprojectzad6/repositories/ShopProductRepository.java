package com.example.mateuszprojectzad6.repositories;

import com.example.mateuszprojectzad6.models.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopProductRepository extends JpaRepository <ShopProduct, Long> {

    @Override
    List<ShopProduct> findAll();

    //ShopProduct findById(Long id);

    //ShopProduct findByName(String name);
}


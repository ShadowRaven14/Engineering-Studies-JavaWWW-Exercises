package com.example.mateuszprojectzad6.repositories;

import com.example.mateuszprojectzad6.models.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShopProductRepository extends JpaRepository <ShopProduct, Long> {

    @Override
    List<ShopProduct> findAll();

    Optional<ShopProduct> findById(Long id);

    ShopProduct findByName(String name);

    //Optional<List<ShopProduct>> findAllByInOrder(Boolean inOrder);

    //Optional<List<ShopProduct>> findShopProductsByInOrder(Boolean inOrder);
}


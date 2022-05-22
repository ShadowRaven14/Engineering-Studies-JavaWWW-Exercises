package com.example.mateuszprojectzad6.repositories;

import com.example.mateuszprojectzad6.models.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository <ShopProduct, Long> {

    @Override
    List<ShopProduct> findAll();

    //ShopProduct findById(Long id);

    //ShopProduct findByName(String name);
}


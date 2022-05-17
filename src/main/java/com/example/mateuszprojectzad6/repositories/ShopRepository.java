package com.example.mateuszprojectzad6.repositories;

import com.example.mateuszprojectzad6.entities.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository <ShopProduct, Long> {

    @Override
    List< ShopProduct > findAll();

    List< ShopProduct > findAlLByDate(LocalDate date);

    //List< Information > findAllByCategory(Category category);

}


package com.example.mateuszprojectzad6.repositories;

import com.example.mateuszprojectzad6.models.ShopItem;
import com.example.mateuszprojectzad6.models.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Long>
{
    @Override
    List<ShopItem> findAll();

    Optional<ShopItem> findById(Long id);

    ShopItem findByName(String name);

}

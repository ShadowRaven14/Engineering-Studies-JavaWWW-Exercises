package com.example.mateuszprojectzad6.services;

import java.util.Optional;
import com.example.mateuszprojectzad6.models.ShopProduct;
import com.example.mateuszprojectzad6.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService
{

    @Autowired
    private ShopRepository shopRepository;


    public ShopProduct addShopProduct(ShopProduct product) {
        shopRepository.save(product);
        return product;
    }

    public java.util.List<ShopProduct> getShopProducts() {
        return shopRepository.findAll();
    }

    public void deleteShopProduct(Long id) throws NoSuchFieldException {
        if (shopRepository.findById(id).isEmpty()) {
            throw new NoSuchFieldException();
        }
        shopRepository.deleteById(id);
    }

    public ShopProduct getShopProductById(Long id) {
        Optional<ShopProduct> optional = shopRepository.findById(id);

        ShopProduct product = null;

        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Kategoria nie znaleziona dla szukanego id :: " + id);
        }
        return product;
    }

}

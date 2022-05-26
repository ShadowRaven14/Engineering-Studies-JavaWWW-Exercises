package com.example.mateuszprojectzad6.services;

import java.util.List;
import java.util.Optional;

import com.example.mateuszprojectzad6.models.ShopProduct;
//import com.example.mateuszprojectzad6.repositories.ShopOrderRepository;
import com.example.mateuszprojectzad6.repositories.ShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    private ShopProductRepository shopProductRepository;

    //@Autowired
    //private ShopOrderRepository shopOrderRepository;



    public java.util.List<ShopProduct> getShopProducts() {
        return shopProductRepository.findAll();
    }

    public Optional<List<ShopProduct>> getShopProductsInOrder() {
        //return shopProductRepository.findShopProductsByInOrder(true);
        return null;
    }

    public ShopProduct addShopProduct(ShopProduct product) {
        product.setInOrder(false);
        product.setQuantity(0);
        shopProductRepository.save(product);
        return product;
    }

    public void deleteShopProduct(Long id) throws NoSuchFieldException {
        if (shopProductRepository.findById(id).isEmpty()) {
            throw new NoSuchFieldException();
        }
        shopProductRepository.deleteById(id);
    }

    public ShopProduct getShopProductById(Long id) {
        Optional<ShopProduct> optional = shopProductRepository.findById(id);

        ShopProduct product = null;

        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Kategoria nie znaleziona dla szukanego id :: " + id);
        }
        return product;
    }

    public void addToCart(ShopProduct product)
    {
        ShopProduct newProduct = product;
        if(shopProductRepository.findById(product.getId()).isEmpty())
        {
            newProduct.setInOrder(true);
            newProduct.setQuantity(1);
            addShopProduct(newProduct);
        }
        else
        {
            newProduct.setInOrder(true);
            newProduct.setQuantity(newProduct.getQuantity()+1);
            addShopProduct(newProduct);
        }

        try {deleteShopProduct(product.getId());}
        catch (NoSuchFieldException e) {throw new RuntimeException(e);}

        //if(shopProductRepository.findById(newItem.getShopProduct().getId()).isEmpty())

    }

}

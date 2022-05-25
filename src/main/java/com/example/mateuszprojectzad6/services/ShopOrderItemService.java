package com.example.mateuszprojectzad6.services;

import com.example.mateuszprojectzad6.models.ShopProduct;
import com.example.mateuszprojectzad6.repositories.ShopOrderItemRepository;
import com.example.mateuszprojectzad6.repositories.ShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShopOrderItemService
{

    @Autowired
    private ShopProductRepository shopProductRepository;

    @Autowired
    private ShopOrderItemRepository shopOrderItemRepository;

    private Map<ShopProduct, Integer> products = new HashMap<>();

    @Autowired
    public ShopOrderItemService(ShopProductRepository productRepository)
    {
        this.shopProductRepository = productRepository;
    }

    public void addProduct(ShopProduct product)
    {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    public void removeProduct(ShopProduct product)
    {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }

    public Map<ShopProduct, Integer> getProductsInCart()
    {
        return Collections.unmodifiableMap(products);
    }

    public void checkout()
    {
        /*
        ShopProduct product;
        for (Map.Entry<ShopProduct, Integer> entry : products.entrySet()) {
            //Refresh quantity for every product before checking
            product = shopProductRepository.findOne(entry.getKey().getId());
            //if (product.getQuantity() < entry.getValue()) return;
            entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
        }
        shopProductRepository.save(products.keySet());
        shopProductRepository.flush();
        products.clear();
         */
    }

    public Double getTotal()
    {
        /*
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
         */
        return null;
    }
}

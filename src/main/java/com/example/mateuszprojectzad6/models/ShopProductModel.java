package com.example.mateuszprojectzad6.models;

import com.example.mateuszprojectzad6.entities.ShopProduct;

import java.util.ArrayList;
import java.util.List;

public class ShopProductModel
{
    private List<ShopProduct> shopProducts;

    public ShopProductModel() {
        this.shopProducts = new ArrayList<ShopProduct>();
        this.shopProducts.add(new ShopProduct("p01", "name 1", "resources/static/images/apple.jpg", 20));
        this.shopProducts.add(new ShopProduct("p02", "name 2", "resources/static/images/apple.jpg", 21));
        this.shopProducts.add(new ShopProduct("p03", "name 3", "resources/static/images/apple.jpg", 22));
    }

    public List<ShopProduct> findAll() {
        return this.shopProducts;
    }

    public ShopProduct find(String id) {
        for (ShopProduct shopProduct : this.shopProducts) {
            if (shopProduct.getId().equalsIgnoreCase(id)) {
                return shopProduct;
            }
        }
        return null;
    }
}

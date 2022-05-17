package com.example.mateuszprojectzad6.models;

import com.example.mateuszprojectzad6.entities.ShopProduct;

import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

@Model
public class ShopProductModel
{
    private List<ShopProduct> shopProducts;

    public ShopProductModel() {
        this.shopProducts = new ArrayList<ShopProduct>();
        this.shopProducts.add(new ShopProduct("p01", "ziemniaki", "resources/static/images/apple.jpg", 200));
        this.shopProducts.add(new ShopProduct("p02", "pomidor", "resources/static/images/apple.jpg", 300));
        this.shopProducts.add(new ShopProduct("p03", "kalafior", "resources/static/images/apple.jpg", 400));
        this.shopProducts.add(new ShopProduct("p04", "ryż", "resources/static/images/apple.jpg", 200));
        this.shopProducts.add(new ShopProduct("p05", "arbuz", "resources/static/images/apple.jpg", 300));
        this.shopProducts.add(new ShopProduct("p06", "woda", "resources/static/images/apple.jpg", 400));
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

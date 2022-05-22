package com.example.mateuszprojectzad6.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem
{
    //Atrybuty
    private ShopProduct shopProduct;

    private int quantity;

    /*
    //Kontruktory
    public ShopItem() {}
    public ShopItem(ShopProduct shopProduct, int quantity) {
        this.shopProduct = shopProduct;
        this.quantity = quantity;
    }

    //Gettery i Settery
    public ShopProduct getProduct() {
        return shopProduct;
    }

    public void setProduct(ShopProduct shopProduct) {
        this.shopProduct = shopProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     */
}

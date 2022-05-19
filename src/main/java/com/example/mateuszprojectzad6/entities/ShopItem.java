package com.example.mateuszprojectzad6.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "CATEGORY")
@Data
public class ShopItem
{
    //Atrybuty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotEmpty
    private ShopProduct shopProduct;

    @NotEmpty
    private int quantity;

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
}

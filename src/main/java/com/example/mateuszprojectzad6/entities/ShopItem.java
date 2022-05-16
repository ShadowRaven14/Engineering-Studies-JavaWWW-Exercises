package com.example.mateuszprojectzad6.entities;

public class ShopItem
{
    //Atrybuty
    private ShopProduct shopProduct;
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

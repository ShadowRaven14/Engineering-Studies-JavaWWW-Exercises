package com.example.mateuszprojectzad6.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//@Component
//@SessionScope
@Entity
@Table(name = "ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem
{
    //Atrybuty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT", nullable = false)
    private ShopProduct shopProduct;

    @Column
    @NotEmpty
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

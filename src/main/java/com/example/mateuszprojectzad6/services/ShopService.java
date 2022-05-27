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



    //PODSTAWOWE
    public java.util.List<ShopProduct> getShopProducts() {
        return shopProductRepository.findAll();
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



    //LISTA PRODUKTÓW
    public ShopProduct addShopProduct(ShopProduct product) {
        shopProductRepository.save(product);
        return product;
    }

    public void updateShopProduct(Long id, ShopProduct currentShopProduct) throws NoSuchFieldException {
        if (shopProductRepository.findById(id).isEmpty()) {throw new NoSuchFieldException();}

        ShopProduct updatedShopProduct = shopProductRepository.findById(id).get();
        updatedShopProduct.setName(currentShopProduct.getName());
        updatedShopProduct.setPrice(currentShopProduct.getPrice());
        updatedShopProduct.setDate(currentShopProduct.getDate());
        updatedShopProduct.setPrice(currentShopProduct.getPrice());
        updatedShopProduct.setPhoto(currentShopProduct.getPhoto());
        updatedShopProduct.setInOrder(currentShopProduct.getInOrder());
        updatedShopProduct.setQuantity(currentShopProduct.getQuantity());

        //Long newID = id;
        //shopProductRepository.deleteById(id);

        updatedShopProduct.setId(id);
        shopProductRepository.save(updatedShopProduct);
    }

    public void deleteShopProduct(Long id) throws NoSuchFieldException {
        if (shopProductRepository.findById(id).isEmpty()) {
            throw new NoSuchFieldException();
        }
        shopProductRepository.deleteById(id);
    }



    //KOSZYK
    public java.util.List<ShopProduct> filterShopProductsByInOrder() {
        return shopProductRepository.findAllByInOrder(true);
    }

    public void addToCart(ShopProduct newProduct) {

        ShopProduct product = shopProductRepository.findById(newProduct.getId()).get();
        shopProductRepository.findById(product.getId());
        if(product.getInOrder()==true) product.setQuantity(product.getQuantity()+1);
        else
        {
            product.setInOrder(true);
            product.setQuantity(1);
        }

        shopProductRepository.save(product);

    }

    public void deleteFromCart(Long id) {

        ShopProduct product = shopProductRepository.findById(id).get();
        //shopProductRepository.findById(product.getId());
        product.setQuantity(0);
        product.setInOrder(false);
        shopProductRepository.save(product);
    }

    public double getTotal()
    {
        double total = 0.0;
        java.util.List<ShopProduct> currentOrder = filterShopProductsByInOrder();
        for (ShopProduct shopProduct : currentOrder)
        {
            total = total +
                    (shopProduct.getPrice() * shopProduct.getQuantity());
        }
        return total;
    }

    public void deleteAllFromCart()
    {
        java.util.List<ShopProduct> currentOrder = filterShopProductsByInOrder();
        for (ShopProduct boughtProduct : currentOrder)
        {
            boughtProduct.setQuantity(0);
            boughtProduct.setInOrder(false);
            shopProductRepository.save(boughtProduct);
        }
    }

    //ZAMÓWIENIA
    /*
    public ShopOrder addOrder(ShopOrder order) {
        shopProductRepository.save(order);
        return order;
    }
    public void finalizeOrder()
    {
        Double toPay = this.getTotal();
        this.deleteAllFromCart();
        ShopOrder newOrder(toPay);
        shopOrderRepository.addOrder(newOrder);
    }
     */



}

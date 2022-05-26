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

    public java.util.List<ShopProduct> filterShopProductsByInOrder() {
        return shopProductRepository.findAllByInOrder(true);
    }

    public ShopProduct addShopProduct(ShopProduct product) {
        //product.setInOrder(false);
        //product.setQuantity(0);
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

    public void addToCart(ShopProduct newProduct)
    {

        ShopProduct product = shopProductRepository.findById(newProduct.getId()).get();
        shopProductRepository.findById(product.getId());
        if(product.getInOrder()==true) product.setQuantity(product.getQuantity()+1);
        else
        {
            product.setInOrder(true);
            product.setQuantity(1);
        }

        shopProductRepository.save(product);

        /*
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
         */

    }

}

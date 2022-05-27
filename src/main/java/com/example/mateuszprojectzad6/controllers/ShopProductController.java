package com.example.mateuszprojectzad6.controllers;

import com.example.mateuszprojectzad6.models.ShopProduct;
import com.example.mateuszprojectzad6.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
//import org.springframework.web.bind.annotation.Controller;


@Controller
public class ShopProductController
{
    @Autowired
    private ShopService shopService;

    //INDEX
    @GetMapping("/ProductPage")
    public String viewProductsPage(Model model) {
        model.addAttribute("listShopProducts", shopService.getShopProducts());
        return "/ProductPage";
    }

    //NOWY PRODUKT
    @GetMapping("/newProductPage")
    public String newShopProductForm(Model model) {
        ShopProduct shopProduct = new ShopProduct();
        model.addAttribute("product", shopProduct);
        return "/newProductPage";
    }

    @PostMapping("/saveShopProduct")
    public String saveShopProduct(@Valid @ModelAttribute("product") ShopProduct product,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "/newProductPage";
        }
        shopService.addShopProduct(product);
        return "redirect:/ProductPage";
    }

    //AKTUALIZUJ PRODUKT
    @GetMapping("/updateShopProductForm/{id}")
    public String updateShopProductForm(@PathVariable(value = "id") Long id, Model model) {
        ShopProduct product = shopService.getShopProductById(id);;
        model.addAttribute("product", product);
        return "/updateProductPage";
    }


    @PostMapping("updateShopProduct/{id}")
    public String saveUpdatedShopProduct(@PathVariable(value = "id") Long id,
                                         @ModelAttribute("product") ShopProduct product)
            throws NoSuchFieldException {
        shopService.updateShopProduct(id,product);
        return "redirect:/ProductPage";
    }


    //KOPIUJ
    @GetMapping("copyShopProduct/{id}")
    public String copyShopProduct(@PathVariable(value = "id") long id, Model model) {
        ShopProduct product = shopService.getShopProductById(id);
        model.addAttribute("product", product);

        return "/updateProductPage";
    }


    //USUŃ PRODUKT
    @GetMapping("deleteShopProduct/{id}")
    public String deleteShopProduct(@PathVariable(value = "id") Long id) throws NoSuchFieldException {
        this.shopService.deleteShopProduct(id);
        return "redirect:/ProductPage";
    }

    //DODAJ DO KOSZYKA
    @GetMapping("addShopProductToOrder/{id}")
    public String addShopProductToOrder(@PathVariable(value = "id") Long id, Model model) {
        ShopProduct product = shopService.getShopProductById(id);
        shopService.addToCart(product);
        model.addAttribute("product", product);
        return "/addProductToOrder";
    }

    @PostMapping("addToCart/{id}")
    public String saveOrderedShopProduct(@PathVariable(value = "id") Long id,
                                         @ModelAttribute("product") ShopProduct product)
            throws NoSuchFieldException {
        //shopService.addToCart(product);
        return "redirect:/ProductPage";
    }
    //addProductToOrder


    /*
    @GetMapping("/add/{id}")
    public String addItemToCart(@PathVariable int id, Model model)
    {
        ShopItem shopItem2Add = shopService.getItem(id);
        if(shopItem2Add == null) throw new DataNotFoundException(String. valueOf(id));
        this.shopService.addToCart(shopItem2Add);
        model.addAttribute( "order", this.shopService.getCart().getItems());
        return "redirect:/OrderPage/";
    }

    @ExceptionHandler(DataNotFoundException. class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No requested data")
    public String handleDataError(DataNotFoundException e) {
        System.out.println("ERROR "+e.getMessage() );
        return "error/notfound";
    }
     */

}
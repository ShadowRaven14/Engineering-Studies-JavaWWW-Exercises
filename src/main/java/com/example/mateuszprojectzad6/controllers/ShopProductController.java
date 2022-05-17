package com.example.mateuszprojectzad6.controllers;

import com.example.mateuszprojectzad6.entities.ShopItem;
import com.example.mateuszprojectzad6.exceptions.DataNotFoundException;
import com.example.mateuszprojectzad6.models.ShopProductModel;
import com.example.mateuszprojectzad6.services.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ShopProductController
{
    ShopService shopService;

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        ShopProductModel shopProductModel = new ShopProductModel();
        modelMap.put("products", shopProductModel.findAll());
        return "ProductPage";
    }

    @GetMapping("/")
    public String newInformationForm(Model model) {
        ShopProductModel shopProductModel = new ShopProductModel();
        model.addAttribute("product", shopProductModel);
        //model.addAttribute("products", shopProductModel.findAll());
        return "newProductPage";
    }

    @GetMapping("/add/{id}")
    public String addItemToCart(@PathVariable int id, Model model)
    {
        ShopItem shopItem2Add = shopService.getItem(id);
        if(shopItem2Add == null) throw new DataNotFoundException(String. valueOf(id));
        this.shopService.addToCart(shopItem2Add);
        model.addAttribute( "cart", this.shopService.getCart().getItems());
        return "redirect:/cart/";
    }
    @ExceptionHandler(DataNotFoundException. class)
    @ResponseStatus(value = HttpStatus. NOT_FOUND, reason = "No requested data")
    public String handleDataError(DataNotFoundException e) {
        System.out.println("ERROR "+e.getMessage() );
        return "error/notfound";
    }

}
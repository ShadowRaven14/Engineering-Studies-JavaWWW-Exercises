package com.example.mateuszprojectzad6.controllers;

import com.example.mateuszprojectzad6.exceptions.DataNotFoundException;
import com.example.mateuszprojectzad6.models.ShopItem;
import com.example.mateuszprojectzad6.models.ShopProduct;
import com.example.mateuszprojectzad6.models.ShopProductList;
import com.example.mateuszprojectzad6.services.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.Controller;
import java.util.List;

@Controller
public class ShopProductController
{
    @Autowired
    private ShopService shopService;

    //Podstawowo
    /*
    @GetMapping("/ProductPage")
    public String index(ModelMap modelMap) {
        ShopProductModel shopProductModel = new ShopProductModel();
        modelMap.put("products", shopProductModel.findAll());
        return "/ProductPage";
    }
     */

    //Inne
    @GetMapping("/ProductPage")
    public String viewCategoriesPage(Model model) {
        model.addAttribute("listShopProducts", shopService.getShopProducts());
        return "/ProductPage";
    }

    @GetMapping("/newProductPage")
    public String newShopProductForm(Model model) {
        ShopProduct shopProduct = new ShopProduct();
        model.addAttribute("product", shopProduct);
        //model.addAttribute("products", shopProductModel.findAll());
        return "newProductPage";
    }

    @PostMapping("/saveShopProduct")
    public String saveShopProduct(@ModelAttribute("product") ShopProduct product) {
        shopService.addShopProduct(product);

        return "redirect:/ProductPage";
    }

    @GetMapping("updateShopProduct/{id}")
    public String updateShopProduct(@PathVariable(value = "id") Long id, Model model) {
        ShopProduct product = shopService.getShopProductById(id);
        //model.addAttribute("listCategories", categoryService.getAllCategories());
        model.addAttribute("product", product);
        return "/updateProductPage";
    }

    @GetMapping("deleteShopProduct/{id}")
    public String deleteShopProduct(@PathVariable(value = "id") Long id) throws NoSuchFieldException {
        this.shopService.deleteShopProduct(id);
        return "redirect:/ProductPage";
    }

    @GetMapping("/OrderPage")
    public String addShopProductToOrder(@PathVariable(value = "id") Long id, Model model) {
        ShopProduct product = shopService.getShopProductById(id);
        model.addAttribute("product", product);
        return "OrderPage";
    }


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
package com.example.mateuszprojectzad6.controllers;

import com.example.mateuszprojectzad6.models.ShopProduct;
import com.example.mateuszprojectzad6.models.ShopOrderItem;
import com.example.mateuszprojectzad6.services.ShopOrderItemService;
import com.example.mateuszprojectzad6.services.ShopProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.Controller;


@Controller
public class ShopProductController
{
    @Autowired
    private ShopProductService shopProductService;

    @Autowired
    private ShopOrderItemService shopOrderItemService;

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
        model.addAttribute("listShopProducts", shopProductService.getShopProducts());
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
        shopProductService.addShopProduct(product);

        return "redirect:/ProductPage";
    }

    @GetMapping("updateShopProduct/{id}")
    public String updateShopProduct(@PathVariable(value = "id") Long id, Model model) {
        ShopProduct product = shopProductService.getShopProductById(id);
        //model.addAttribute("listCategories", categoryService.getAllCategories());
        model.addAttribute("product", product);
        return "/updateProductPage";
    }

    @GetMapping("deleteShopProduct/{id}")
    public String deleteShopProduct(@PathVariable(value = "id") Long id) throws NoSuchFieldException {
        this.shopProductService.deleteShopProduct(id);
        return "redirect:/ProductPage";
    }


    @GetMapping("/addToOrder/{id}")
    public String addItemToCart(@PathVariable Long id, Model model)
    {
        ShopOrderItem shopItem2Add = shopProductService.getOrderItem(id);
        //if(shopItem2Add == null) throw new DataNotFoundException(String. valueOf(id));
        this.shopProductService.addToOrder(shopItem2Add);
        model.addAttribute( "order", this.shopProductService.getOrder().getItems());
        return "redirect:/OrderPage/";
    }

    /*
    @ExceptionHandler(DataNotFoundException. class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No requested data")
    public String handleDataError(DataNotFoundException e) {
        System.out.println("ERROR "+e.getMessage() );
        return "error/notfound";
    }
     */


}
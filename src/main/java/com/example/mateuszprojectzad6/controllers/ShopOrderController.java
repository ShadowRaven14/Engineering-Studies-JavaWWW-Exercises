package com.example.mateuszprojectzad6.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.example.mateuszprojectzad6.models.ShopProduct;
import com.example.mateuszprojectzad6.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class ShopOrderController
{

    @Autowired
    private ShopService shopService;

    public List<ShopProduct> addToList()
    {
        List<ShopProduct> shopProductList = shopService.getShopProducts();
        List<ShopProduct> newShopProductsInOrder = null;
        for (ShopProduct shopProduct : shopProductList)
        {
            if(shopProduct.getInOrder()==true)
                newShopProductsInOrder.add(shopProduct);
        }

        ShopProduct newProduct = new ShopProduct("PUSTO", 1000.00, true, 3);
        newShopProductsInOrder.add(newProduct);
        return newShopProductsInOrder;
    }

    /*
    @GetMapping("/ProductPage")
    public String viewCategoriesPage(Model model) {
        model.addAttribute("listShopProducts", shopService.getShopProducts());
        return "/OrderPage";
    }
     */

    @GetMapping("/OrderPage")
    public String index(Model model)
    {
        List<ShopProduct> shopProductsInOrder = this.addToList();
        model.addAttribute("shopProductsInOrder", shopProductsInOrder);
        return "/OrderPage";
    }

    /*
    @GetMapping("buy/{id}")
    public String buy(@PathVariable("id") Long id, HttpSession session) {
        //ShopProductList shopProductList = new ShopProductList();
        if (session.getAttribute("order") == null) {
            List<ShopItem> order = new ArrayList<ShopItem>();
            order.add(new ShopItem(find(id), 1));
            session.setAttribute("order", order);
        } else {
            List<ShopItem> order = (List<ShopItem>) session.getAttribute("order");
            int index = this.exists(id, order);
            if (index == -1) {
                order.add(new ShopItem(find(id), 1));
            } else {
                int quantity = order.get(index).getQuantity() + 1;
                order.get(index).setQuantity(quantity);
            }
            session.setAttribute("order", order);
        }
        return "redirect:/OrderPage";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") Long id, HttpSession session) {
        //ShopProductList shopProductList = new ShopProductList();
        List<ShopItem> order = (List<ShopItem>) session.getAttribute("order");
        int index = this.exists(id, order);
        order.remove(index);
        session.setAttribute("order", order);
        return "redirect:/OrderPage";
    }

    private int exists(Long id, List<ShopItem> order) {
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getShopProduct().getId()==id) {
                return i;
            }
        }
        return -1;
    }
    */


}

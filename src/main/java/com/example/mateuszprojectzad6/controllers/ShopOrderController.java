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

    //INDEX
    @GetMapping("/OrderPage")
    public String index(Model model) {
        //ShopProduct newProduct = new ShopProduct("PUSTO", 1.00, true, 1);
        //shopService.addShopProduct(newProduct);
        Double total = shopService.getTotal();
        model.addAttribute("shopProductsInOrder",
                shopService.filterShopProductsByInOrder());
        model.addAttribute("total", total);
        return "/OrderPage";
    }

    @GetMapping("/deleteFromOrder/{id}")
    public String deleteFromCart(@PathVariable(value = "id") Long id) throws NoSuchFieldException {
        this.shopService.deleteFromCart(id);
        return "redirect:/OrderPage";
    }

    @GetMapping("/deleteAllFromCart")
    public String checkoutOrder() {
        this.shopService.deleteAllFromCart();
        return "redirect:/OrderPage";
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

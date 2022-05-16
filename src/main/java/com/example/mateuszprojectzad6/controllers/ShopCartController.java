package com.example.mateuszprojectzad6.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.example.mateuszprojectzad6.entities.ShopItem;
import com.example.mateuszprojectzad6.models.ShopProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "cart")
public class ShopCartController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "cart/index";
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") String id, HttpSession session) {
        ShopProductModel shopProductModel = new ShopProductModel();
        if (session.getAttribute("cart") == null) {
            List<ShopItem> cart = new ArrayList<ShopItem>();
            cart.add(new ShopItem(shopProductModel.find(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<ShopItem> cart = (List<ShopItem>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new ShopItem(shopProductModel.find(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart/index";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") String id, HttpSession session) {
        ShopProductModel shopProductModel = new ShopProductModel();
        List<ShopItem> cart = (List<ShopItem>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/cart/index";
    }

    private int exists(String id, List<ShopItem> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

}

package com.example.mateuszprojectzad6.controllers;

import com.example.mateuszprojectzad6.models.ShopProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "product")
public class ShopProductController
{

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        ShopProductModel shopProductModel = new ShopProductModel();
        modelMap.put("products", shopProductModel.findAll());
        return "product/index";
    }

}
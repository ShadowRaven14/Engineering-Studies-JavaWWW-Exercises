/*
package com.example.mateuszprojectzad6.controllers;

import org.hibernate.Hibernate;
import org.munif.domain.Category;
import org.munif.domain.Product;
import org.munif.service.CategoryService;
import org.munif.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class NewProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    // Registering CategoryEditor class.
    // If you need any other editor class declaration, you can register inside this method.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
    }


    @RequestMapping(value="/product/", method=RequestMethod.GET)
    public ModelAndView productHome() {
        ModelAndView mav = new ModelAndView("/product/list");
        Hibernate.initialize(productService.findAll());
        mav.addObject("products", productService.findAll());

        return mav;
    }



    @RequestMapping(value="/product/add", method=RequestMethod.GET)
    public ModelAndView productForm() {
        ModelAndView mav = new ModelAndView("/product/add");
        mav.addObject("productBean", new Product());
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @RequestMapping(value="/product/addProductConfirm", method=RequestMethod.POST)
    public ModelAndView productAddConfirm(@ModelAttribute Product product, BindingResult result) {
        ModelAndView mav = new ModelAndView("redirect:/product/");
        productService.addProduct(product);

        return mav;
    }


    @RequestMapping(value="/product/cat/{categoryId}", method=RequestMethod.GET)
    public ModelAndView productListByCategory(@PathVariable Integer categoryId) {
        ModelAndView mav = new ModelAndView("/product/listByCategory");

        mav.addObject("products", categoryService.findById(categoryId).getProducts());
        mav.addObject("categoryName", categoryService.findById(categoryId).getCategoryName());

        return mav;
    }
}
}

 */

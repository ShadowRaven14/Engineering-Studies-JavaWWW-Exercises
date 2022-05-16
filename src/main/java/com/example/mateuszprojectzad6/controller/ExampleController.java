package com.example.mateuszprojectzad6.controller;

import com.example.mateuszprojectzad6.model.DataNotFoundException;
import com.example.mateuszprojectzad6.model.Item;
import com.example.mateuszprojectzad6.model.Service;
import com.example.mateuszprojectzad6.repository.ExampleDataRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Data
@RequiredArgsConstructor
@Controller
public class ExampleController
{
    @Autowired
    ExampleDataRepository repository;

    Service service;

    @GetMapping("/getUsers")
    public String getAll(Model model) {
        System.out.println("GET ALL");
        model.addAttribute("users", repository.getData());
        return "printData";
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("HOME");
        return "home";
    }

    @RequestMapping(value = "/login", method = GET)
    public String login() {
        System.out.println("LOGIN");
        return "login";
    }

    @RequestMapping(value="/getUsersWithRange", params={"min"})
    @GetMapping(value="/getUsersWithRange",params={"min","max"})
    public String getRange(Model model, final HttpServletRequest req)
    {
        System.out.println("GET RANGE");
        model.addAttribute("users",
                repository.getRangeData(req.getParameter("min"),req.getParameter("max")));
        return "printData";
    }

    /*
    @GetMapping("/getUsersWithRange")
    public String getRange(Model model, @RequestParam("min") String min, @RequestParam("max") String max))
    {
        System.out.println("GET RANGE");
        model.addAttribute("users", repository.getRangeData(min,max));
        return "printData";
    }

    @GetMapping("/getUser/{id}")
    public String getRange(Model model, @PathVariable("id") String id)
    {
        System.out.println("GET ONE");
        model.addAttribute("user", repository.getOneData(id));
        return "printOne";
    }

    @GetMapping("/getUser/{id}")
    public String getRange(Model model, @PathVariable String id) {
        System.out.println("GET ONE");
        model.addAttribute("user", repository.getOneData(id));
        return "printOne";
    }
     */

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError()
    {
        System.out.println("ERROR");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No requested data")
    public void handleDataError()
    {
        System.out.println("ERROR");
    }


    @GetMapping("/add/{id}")
    public String addItemToCart(@PathVariable int id, Model model)
    {
        try
        {
            Item item2add = service.getItem(id);
            if(item2add== null) throw new DataNotFoundException(String. valueOf(id));
            this.service.addToCart(item2add);
            model.addAttribute( "cart", this.service.getCart().getItems());
            return "redirect:/cart/";
        }
        catch (Exception e)
        {
            System.out.println("error "+e.getMessage());
            model.addAttribute( "errorMsg",e.getMessage());
            return "error";
        }
    }


    /*
    @GetMapping("/add/{id}")
    public String addItemToCart(@PathVariable int id, Model model)
    {
        Item item2add= service.getItem(id);
        if(item2add== null) throw new DataNotFoundException(String. valueOf(id));
        this.service.addToCart(item2add);
        model.addAttribute( "cart", this.service.getCart().getItems());
        return "redirect:/cart/";
    }
    @ExceptionHandler (DataNotFoundException. class)
    @ResponseStatus (value = HttpStatus. NOT_FOUND, reason = "No requested data")
    public String handleDataError(DataNotFoundException e) {
        System.out.println("ERROR "+e.getMessage() );
        return "error/notfound";
    }
     */
}
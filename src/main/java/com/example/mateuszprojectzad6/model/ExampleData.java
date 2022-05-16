package com.example.mateuszprojectzad6.model;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ExampleData
{
    private int id;
    private String name;
    private int age;

    @GetMapping("/printData")
    public String getAllData(Model model) {
        model.addAttribute("name", "Ala Makota");
        model.addAttribute("age", 23);
        model.addAttribute("login", "abc12we");
        return "printData";
    }

    @GetMapping("/printData")
    public ExampleData getAllData() {
        return new ExampleData(1,"Ala Makota",23);
    }

    public ExampleData(int id, String name, int age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age=age;
    }

}
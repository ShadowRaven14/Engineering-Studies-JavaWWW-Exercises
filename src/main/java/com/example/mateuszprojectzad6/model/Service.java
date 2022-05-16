package com.example.mateuszprojectzad6.model;

import java.awt.*;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Component
public class Service
{

    public Item getItem(int id)
    {
        return null;
    }

    public List getCart()
    {
        return null;
    }

    public void addToCart(Item item2add)
    {
        return;
    }
}

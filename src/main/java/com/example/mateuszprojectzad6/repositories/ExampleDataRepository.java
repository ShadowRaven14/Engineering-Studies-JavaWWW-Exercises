package com.example.mateuszprojectzad6.repositories;

import com.example.mateuszprojectzad6.entities.ExampleData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExampleDataRepository
{
    List<ExampleData> users;

    public ExampleDataRepository() {
        this.users = new ArrayList<>();
        this.users.add(new ExampleData(1, "Ala Makota", 23));
    }

    public Object getData()
    {
        return null;
    }

    public Object getRangeData(String min, String max)
    {
        return null;
    }


    public Object getOneData(String id)
    {
        return null;
    }
}
package com.example.mateuszprojectzad6.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No data found")
public class DataNotFoundException extends RuntimeException
{
    public DataNotFoundException(String msg)
    {
        super(msg);
    }
}

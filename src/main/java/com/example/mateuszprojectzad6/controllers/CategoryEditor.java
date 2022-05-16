/*
package com.example.mateuszprojectzad6.controllers;

import java.beans.PropertyEditorSupport;
import org.munif.domain.Category;
import org.munif.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryEditor extends PropertyEditorSupport {

    // Do not use @Autowired.
    // Use dependency injection in class constructor.
    private final CategoryService categoryService;

    public CategoryEditor() {
        this.categoryService = null;
    }

    //This constructor will be used to inject the categoryService.
    public CategoryEditor(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // Find a category by its categoryId from text
        Category category = categoryService.findById(Integer.parseInt(text));
        setValue(category);
    }
}
 */
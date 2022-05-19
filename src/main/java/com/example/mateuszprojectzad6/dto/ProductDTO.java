package com.example.mateuszprojectzad6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @Size(min = 3, max = 20, message = "Title must be between 3 and 20 characters long")
    @NotEmpty
    private String title;

    @NotEmpty
    @Size(min = 5, max = 500, message = "Content must be between 3 and 500 characters long")
    private String content;


}


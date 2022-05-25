package com.example.mateuszprojectzad6.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopProduct
{
    //Atrybuty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    @NotEmpty
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    @Pattern(regexp = "^[a-z]+$", message = "Must contains only small letters")
    private String name;

    @NotEmpty
    @Min(value = 10, message = "Price must be greater than 10")
    @Column(length = 20, nullable = false)
    private Double price;

    @NotEmpty
    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotEmpty
    @Column(length = 20, nullable = true)
    private String photo;

    @NotEmpty
    @Column(length = 20, nullable = false)
    private Boolean inOrder;

    @NotEmpty
    @Column(nullable = false)
    private Integer quantity;

    public ShopProduct( String name, Double price, Boolean inOrder, Integer quantity) {
        this.name = name;
        this.price = price;
        this.inOrder = inOrder;
        this.quantity = quantity;
    }

}

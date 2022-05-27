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
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    @Pattern(regexp = "^[a-z]+$", message = "Must contains only small letters")
    @Column(name = "name", length = 20)
    private String name;

    @NotEmpty
    @Min(value = 10, message = "Price must be greater than 10")
    @Column(name = "price", length = 20, nullable = false)
    private Double price;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", length = 20, nullable = true)
    private LocalDate date;

    @NotEmpty
    @Column(name = "photo", length = 20, nullable = true)
    private String photo;

    @NotEmpty
    @Column(name = "inOrder", length = 20, nullable = false)
    private Boolean inOrder;

    @NotEmpty
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public ShopProduct( String name, Double price, Boolean inOrder, Integer quantity) {
        this.name = name;
        this.price = price;
        this.inOrder = inOrder;
        this.quantity = quantity;
    }

}

package org.example.spring_learn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String category;
    private String brand;
    private BigDecimal price;
    private int quantity;
    private boolean available;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;

    public String toString(){
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
                + ", brand=" + brand + ", price=" + price + ", quantity=" + quantity + ", available=" + available
                + ", releaseDate=" + releaseDate + "]";
    }

}

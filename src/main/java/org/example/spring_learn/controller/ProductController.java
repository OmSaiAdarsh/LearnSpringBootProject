package org.example.spring_learn.controller;

import org.example.spring_learn.model.Product;
import org.example.spring_learn.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        try {
            productService.addProduct(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

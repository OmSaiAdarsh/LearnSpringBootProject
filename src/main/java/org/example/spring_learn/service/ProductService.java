package org.example.spring_learn.service;

import java.util.List;
import org.example.spring_learn.model.Product;

public interface ProductService {
    public List<Product> getProducts();
    public Product getProductById(int id);
    public Product addProduct(Product product);
}

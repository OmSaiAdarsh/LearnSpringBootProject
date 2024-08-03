package org.example.spring_learn.service;

import org.example.spring_learn.model.Product;
import org.example.spring_learn.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    //List<Product> products = new ArrayList<Product>(Arrays.asList( new Product()));

    public ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseGet(Product::new);

    }

    public Product addProduct(Product product){
        System.out.println(product);
        return productRepository.save(product);
    }

}

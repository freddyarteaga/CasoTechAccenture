package com.example.demo.product;

import com.example.demo.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    private static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "papel higienico", 2000));
        products.add(new Product(2, "papel", 1500));
        products.add(new Product(3, "caca", 455));
        return products;
    }

    private  List<Product> products = loadProducts();

    public List<Product> getProducts() {
        return products;
    }

    public String addProducts(Product product) {
        products.add(product);
        System.out.println(products);
        return "Product Add Succesfully";
    }
}

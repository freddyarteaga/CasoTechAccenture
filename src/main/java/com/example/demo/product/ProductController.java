package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/getProducts")
    public List<Product> getProducts(){

//        return studentService.getStudent();
//        Db db = new Db();
        return service.getProducts();

    }

    @PostMapping("/addProducts")
    public String addProducts(@RequestBody Product product) {

        return service.addProducts(product);
//
    }
}

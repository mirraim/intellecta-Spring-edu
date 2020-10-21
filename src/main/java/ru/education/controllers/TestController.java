package ru.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.jpa.Product;
import ru.education.jpa.ProductRepository;
import ru.education.model.Formatter;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TestController {

    private final ProductRepository productRepository;

    private final Formatter formatter;

    @Autowired
    public TestController(@Qualifier("fooFormatter") Formatter formatter, ProductRepository productRepository) {
        this.formatter = formatter;
        this.productRepository = productRepository;
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello, world!";
    }

    @GetMapping("/format")
    public String getFormat(){
        return formatter.format();
    }

    @GetMapping("/products")
    public List<Product> getProduct(){
        return productRepository.findAll();
    }
}

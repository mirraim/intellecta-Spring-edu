package ru.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.entity.OrdersJdbcDemo;
import ru.education.jdbc.OrdersJdbcRepository;
import ru.education.jpa.Product;
import ru.education.jpa.ProductRepository;
import ru.education.model.Formatter;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TestController {

    private final ProductRepository productRepository;

    private final Formatter formatter;

    private OrdersJdbcRepository ordersJdbcRepository;

    @Autowired
    public TestController(@Qualifier("fooFormatter") Formatter formatter, ProductRepository productRepository, OrdersJdbcRepository ordersJdbcRepository) {
        this.formatter = formatter;
        this.productRepository = productRepository;
        this.ordersJdbcRepository = ordersJdbcRepository;
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

    @GetMapping("/orders/count")
    public Integer getordersCount(){
        return ordersJdbcRepository.count();
    }

    @GetMapping("orders/list")
    public List<OrdersJdbcDemo> getOrders(){
        return ordersJdbcRepository.getOrders();
    }

    @GetMapping("/products/ordered-anny")
    public List<Product> orderedProduct(){
        return ordersJdbcRepository.orderedProduct();
    }
}

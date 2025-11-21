package com.example.product_service.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.entity.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping
public class ProductController {
    
    private static final ArrayList<Product> al = new ArrayList<>();
    static{
        al.add(new Product(
                1,
                "Nike Shoes",
                2499,
                "https://images.unsplash.com/photo-1542291026-7eec264c27ff"
        ));

        al.add(new Product(
                2,
                "Boat Earbuds",
                899,
                "https://images.unsplash.com/photo-1590658268037-6bf12165a8df"
        ));

        al.add(new Product(
                3,
                "HP Laptop",
                59999,
                "https://images.unsplash.com/photo-1517336714731-489689fd1ca8"
        ));

        al.add(new Product(
            4,
            "Denim Jeans",
            1599,
            "https://images.unsplash.com/photo-1541099277846-9538c64d271f"
        ));

        al.add(new Product(
            5,
            "Smartwatch",
            3499,
            "https://images.unsplash.com/photo-1546868882-948f2b7a8d56"
        ));

        al.add(new Product(
            6,
            "Coffee Maker",
            4199,
            "https://images.unsplash.com/photo-1563248384-58a4369a474d"
        ));

        al.add(new Product(
            7,
            "Gaming Mouse",
            1249,
            "https://images.unsplash.com/photo-1616091497217-1f8d951239c0"
        ));
    }

    @GetMapping("/get/products")
    public ArrayList<Product> getAll() {
        return al;
    }
    @GetMapping("/get/products/{id}")
    public Product getWithId(@PathVariable int id) {
        for(Product p : al){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    
    
}

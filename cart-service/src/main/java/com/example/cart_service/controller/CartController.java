package com.example.cart_service.controller;

import com.example.cart_service.entity.CartItem;
import com.example.cart_service.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestParam int userId,
            @RequestParam int productId,
            @RequestParam(defaultValue = "1") int quantity) {

        String msg = service.add(userId, productId, quantity);
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public List<CartItem> getCart(@RequestParam int userId) {
        return service.getCart(userId);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> remove(
            @RequestParam int userId,
            @RequestParam int productId) {

        return ResponseEntity.ok(service.remove(userId, productId));
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clear(@RequestParam int userId) {
        return ResponseEntity.ok(service.clear(userId));
    }
}

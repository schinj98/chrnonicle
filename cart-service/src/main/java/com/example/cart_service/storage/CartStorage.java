package com.example.cart_service.storage;

import com.example.cart_service.entity.CartItem;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CartStorage {

    // userId -> list of CartItem
    private Map<Integer, List<CartItem>> carts = new HashMap<>();

    public List<CartItem> getCart(int userId) {
        return carts.getOrDefault(userId, new ArrayList<>());
    }

    public void saveCart(int userId, List<CartItem> cart) {
        carts.put(userId, cart);
    }
}

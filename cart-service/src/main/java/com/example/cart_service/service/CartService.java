package com.example.cart_service.service;

import com.example.cart_service.entity.CartItem;
import com.example.cart_service.storage.CartStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartStorage cartStorage;

    public CartService(CartStorage cartStorage) {
        this.cartStorage = cartStorage;
    }

    public String add(int userId, int productId, int quantity) {

        List<CartItem> cart = cartStorage.getCart(userId);

        for (CartItem item : cart) {
            if (item.getProductId() == productId) {
                int newQty = item.getQuantity() + quantity;
                cart.remove(item);
                cart.add(new CartItem(productId, newQty));
                cartStorage.saveCart(userId, cart);
                return "Quantity updated";
            }
        }

        cart.add(new CartItem(productId, quantity));
        cartStorage.saveCart(userId, cart);

        return "Product added";
    }

    public List<CartItem> getCart(int userId) {
        return cartStorage.getCart(userId);
    }

    public String remove(int userId, int productId) {
        List<CartItem> cart = cartStorage.getCart(userId);
        cart.removeIf(item -> item.getProductId() == productId);
        cartStorage.saveCart(userId, cart);
        return "Item removed";
    }

    public String clear(int userId) {
        cartStorage.saveCart(userId, new java.util.ArrayList<>());
        return "Cart cleared";
    }
}

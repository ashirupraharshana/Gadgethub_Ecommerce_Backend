package com.project.ecommerce.service;

import com.project.ecommerce.model.Cart;
import com.project.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Add item to cart
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Get all cart items for a specific user
    public List<Cart> getUserCart(int userid) {
        return cartRepository.findByUserid(userid);
    }

    // Update an existing cart item
    public Cart updateCart(Long id, Cart cart) {
        Cart existing = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + id));

        existing.setQuantity(cart.getQuantity());
        existing.setTotalprice(cart.getTotalprice());
        return cartRepository.save(existing);
    }

    // Remove a specific cart item
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    // Clear all cart items for a specific user
    public void clearUserCart(int userid) {
        List<Cart> carts = cartRepository.findByUserid(userid);
        cartRepository.deleteAll(carts);
    }
}

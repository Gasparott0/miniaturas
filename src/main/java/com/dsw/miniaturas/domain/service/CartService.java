package com.dsw.miniaturas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.miniaturas.api.dto.CartItemDTO;
import com.dsw.miniaturas.domain.model.Cart;
import com.dsw.miniaturas.domain.model.CartItem;
import com.dsw.miniaturas.domain.model.Miniature;
import com.dsw.miniaturas.domain.model.User;
import com.dsw.miniaturas.domain.repository.CartItemRepository;
import com.dsw.miniaturas.domain.repository.CartRepository;
import com.dsw.miniaturas.domain.repository.MiniatureRepository;
import com.dsw.miniaturas.domain.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MiniatureRepository miniatureRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;

	public Cart findByUserId(Long userId) {
		return cartRepository.findByUserId(userId);
	}

	public Cart addToCart(Long userId, CartItemDTO cartItemDTO) {
		Cart cart = cartRepository.findByUserId(userId);
		if (cart != null) {
			addItem(cart, cartItemDTO);
		} else {
			User user = userRepository.findById(userId).get();
			cart = new Cart();
			cart.setUser(user);
			cartRepository.save(cart);
			addItem(cart, cartItemDTO);
		}
		return cartRepository.save(cart);
	}

	private void addItem(Cart cart, CartItemDTO cartItemDTO) {
		Miniature miniature = miniatureRepository.findById(cartItemDTO.getMiniatureId()).get();
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setMiniature(miniature);
		cartItem.setQuantity(cartItemDTO.getQuantity());
		cartItemRepository.save(cartItem);
	}
}

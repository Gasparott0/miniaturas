package com.dsw.miniaturas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dsw.miniaturas.api.dto.CartItemDTO;
import com.dsw.miniaturas.api.dto.HistoryDTO;
import com.dsw.miniaturas.api.dto.UserLoginDTO;
import com.dsw.miniaturas.domain.model.Cart;
import com.dsw.miniaturas.domain.model.History;
import com.dsw.miniaturas.domain.model.User;
import com.dsw.miniaturas.domain.service.CartService;
import com.dsw.miniaturas.domain.service.HistoryService;
import com.dsw.miniaturas.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private CartService cartService;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserLoginDTO abstractUser) {

		User user = userService.login(abstractUser);
		if (user != null)
			return ResponseEntity.ok(user);

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User user) {

		return userService.save(user);
	}

	@GetMapping("/history/{userId}")
	public List<String> listHistory(@PathVariable Long userId) {
		return historyService.list(userId);
	}

	@PostMapping("/history/add-miniature")
	@ResponseStatus(HttpStatus.CREATED)
	public History addToHistory(@RequestBody HistoryDTO historyDTO) {

		return historyService.save(historyDTO);
	}

	@GetMapping("/cart/{userId}")
	public Cart listCart(@PathVariable Long userId) {
		return cartService.findByUserId(userId);
	}

	@PostMapping("/cart/{userId}/add-item")
	@ResponseStatus(HttpStatus.CREATED)
	public Cart addToCart(@PathVariable Long userId, @RequestBody CartItemDTO cartItemDTO) {

		return cartService.addToCart(userId, cartItemDTO);
	}

}

package com.dsw.miniaturas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsw.miniaturas.domain.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	public Cart findByUserId(Long userId);

}

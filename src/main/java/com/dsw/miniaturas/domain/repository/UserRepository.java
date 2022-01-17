package com.dsw.miniaturas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsw.miniaturas.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByCpf(String cpf);

}

package com.dsw.miniaturas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.miniaturas.api.dto.UserLoginDTO;
import com.dsw.miniaturas.domain.model.User;
import com.dsw.miniaturas.domain.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User login(UserLoginDTO loginDTO) {
		User user = userRepository.findByCpf(loginDTO.getCpf());

		if (user != null && user.getPassword().equals(loginDTO.getPassword()))
			return user;

		return null;
	}

	public User save(User user) {
		return userRepository.save(user);
	}
}

package com.dsw.miniaturas.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("unused")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cpf;
	private String password;
	private String name;
	private String email;
	private String state;
	private String cep;
	private String address;
	private String city;
	private String number;
	private LocalDateTime dateCreated;
}

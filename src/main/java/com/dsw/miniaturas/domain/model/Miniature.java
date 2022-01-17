package com.dsw.miniaturas.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("unused")
public class Miniature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String brand;
	private String model;
	private String year;
	private String color;
	private String acceleration;
	private String power;
	private String torque;
	private String maxSpeed;
	private String consumption;
	private Integer seats;
	private String weight;
	private BigDecimal price;
}

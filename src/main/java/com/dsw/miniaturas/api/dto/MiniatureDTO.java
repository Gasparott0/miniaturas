package com.dsw.miniaturas.api.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MiniatureDTO {

	private long id;
	private String brand;
	private String model;
	private BigDecimal price;
	private String image;
}

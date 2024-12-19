package com.redeban.product.dto.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class CategoryDTO {

	@Positive
	private int id;
	@NotEmpty
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

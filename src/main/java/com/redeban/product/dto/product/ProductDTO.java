package com.redeban.product.dto.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductDTO {

	private int id;
	@NotNull
	@NotEmpty
	private String name;
	@Positive
	private Double price;
	@NotNull
	@Positive
	private Double listPrice;
	private String priceValidUntil;
	@Valid
	private CategoryDTO categoryId;
	private String creationDate;
	private String updateDate;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public String getPriceValidUntil() {
		return priceValidUntil;
	}

	public void setPriceValidUntil(String priceValidUntil) {
		this.priceValidUntil = priceValidUntil;
	}

	public CategoryDTO getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryDTO categoryId) {
		this.categoryId = categoryId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}

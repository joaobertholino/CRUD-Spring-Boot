package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.Product;

public class ProductDto {
	private String name;
	private String description;
	private Double price;

	public ProductDto() {
	}

	public ProductDto(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

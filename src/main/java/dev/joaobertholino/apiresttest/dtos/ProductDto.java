package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductDto {
	private String name;
	private String description;
	private Double price;
	private Set<OrderItemDto> orderItem;

	public ProductDto() {
	}

	public ProductDto(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.orderItem = product.getORDER_ITEMS().stream().map(orderItem -> new OrderItemDto(orderItem)).collect(Collectors.toSet());
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

	public Set<OrderItemDto> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<OrderItemDto> orderItem) {
		this.orderItem = orderItem;
	}
}

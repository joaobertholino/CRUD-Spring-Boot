package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.OrderItem;

public class OrderItemDto {
	private Integer amount;
	private Double price;
	private String productName;
	private Double subTotal;

	public OrderItemDto() {
	}

	public OrderItemDto(OrderItem orderItem) {
		this.amount = orderItem.getAmount();
		this.price = orderItem.getPrice();
		this.productName = orderItem.getId().getProduct().getName();
		this.subTotal = this.amount * this.price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
}

package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.Order;
import dev.joaobertholino.apiresttest.models.enums.OrderStatus;

import java.time.LocalDateTime;

public class OrderDto {
	private LocalDateTime orderDate;
	private OrderStatus status;

	public OrderDto() {
	}

	public OrderDto(Order order) {
		this.orderDate = order.getOrderDate();
		this.status = order.getStatus();
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}

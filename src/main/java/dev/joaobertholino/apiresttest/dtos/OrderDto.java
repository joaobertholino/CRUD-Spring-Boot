package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.Order;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class OrderDto {

	@NotNull
	private LocalDateTime orderDate;

	public OrderDto() {
	}

	public OrderDto(Order order) {
		this.orderDate = order.getOrderDate();
	}

	public @NotNull LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(@NotNull LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
}

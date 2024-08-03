package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.Order;
import dev.joaobertholino.apiresttest.models.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class OrderDto {

	@NotNull
	private LocalDateTime orderDate;

	@NotNull
	private OrderStatus status;

	public OrderDto() {
	}

	public OrderDto(Order order) {
		this.orderDate = order.getOrderDate();
		this.status = order.getStatus();
	}

	public @NotNull LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(@NotNull LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public @NotNull OrderStatus getStatus() {
		return status;
	}

	public void setStatus(@NotNull OrderStatus status) {
		this.status = status;
	}
}

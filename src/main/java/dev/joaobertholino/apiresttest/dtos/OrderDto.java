package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.Order;
import dev.joaobertholino.apiresttest.models.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderDto {
	private LocalDateTime orderDate;
	private OrderStatus status;
	private Set<OrderItemDto> orderItemDto;

	public OrderDto() {
	}

	public OrderDto(Order order) {
		this.orderDate = order.getOrderDate();
		this.status = order.getStatus();
		this.orderItemDto = order.getITEMS().stream().map(orderItem -> new OrderItemDto(orderItem)).collect(Collectors.toSet());
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

	public Set<OrderItemDto> getOrderItemDto() {
		return orderItemDto;
	}

	public void setOrderItemDto(Set<OrderItemDto> orderItemDto) {
		this.orderItemDto = orderItemDto;
	}
}

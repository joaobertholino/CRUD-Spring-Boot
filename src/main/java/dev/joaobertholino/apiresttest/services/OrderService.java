package dev.joaobertholino.apiresttest.services;

import dev.joaobertholino.apiresttest.dtos.OrderDto;
import dev.joaobertholino.apiresttest.models.Order;
import dev.joaobertholino.apiresttest.repositories.OrderRepository;
import dev.joaobertholino.apiresttest.services.exceptions.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<OrderDto> findAll() {
		List<Order> orderList = this.orderRepository.findAll();
		if (orderList.isEmpty()) throw new OrderNotFoundException("Order list is empty");
		return orderList.stream().map(order -> new OrderDto(order)).toList();
	}

	public OrderDto findById(UUID id) {
		Optional<Order> result = this.orderRepository.findById(id);
		return new OrderDto(result.orElseThrow(() -> new OrderNotFoundException("Order referring to the id provided was not found")));
	}
}

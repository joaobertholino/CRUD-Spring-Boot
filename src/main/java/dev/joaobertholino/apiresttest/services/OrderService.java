package dev.joaobertholino.apiresttest.services;

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

	public List<Order> findAll() {
		return this.orderRepository.findAll();
	}

	public Order findById(UUID id) {
		Optional<Order> result = this.orderRepository.findById(id);
		return result.orElseThrow(() -> new OrderNotFoundException());
	}
}

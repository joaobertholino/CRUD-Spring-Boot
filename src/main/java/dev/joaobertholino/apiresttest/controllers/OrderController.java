package dev.joaobertholino.apiresttest.controllers;

import dev.joaobertholino.apiresttest.dtos.OrderDto;
import dev.joaobertholino.apiresttest.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping(value = "all")
	public ResponseEntity<List<OrderDto>> findAll() {
		List<OrderDto> listOrderDto = this.orderService.findAll().stream().map(order -> new OrderDto(order)).toList();
		return ResponseEntity.status(HttpStatus.FOUND).body(listOrderDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDto> findById(@PathVariable UUID id) {
		OrderDto orderDto = new OrderDto(this.orderService.findById(id));
		return ResponseEntity.status(HttpStatus.FOUND).body(orderDto);
	}
}

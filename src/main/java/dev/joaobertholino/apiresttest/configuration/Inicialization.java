package dev.joaobertholino.apiresttest.configuration;

import dev.joaobertholino.apiresttest.models.*;
import dev.joaobertholino.apiresttest.models.enums.*;
import dev.joaobertholino.apiresttest.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class Inicialization implements CommandLineRunner {
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final OrderItemRepository orderItemRepository;

	public Inicialization(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Joao", "Bertholino", "joao@email.com");
		User u2 = new User("Ellen", "Sthefani", "ellen@email.com");
		this.userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1u1 = new Order(LocalDateTime.parse("2024-04-03T10:15:30"), OrderStatus.PAYMENT, u1);
		Order o1u2 = new Order(LocalDateTime.parse("2024-03-04T10:15:30"), OrderStatus.CANCELLED, u1);
		Order o2u1 = new Order(LocalDateTime.parse("2024-08-05T13:34:12"), OrderStatus.SENT, u2);
		Order o2u2 = new Order(LocalDateTime.parse("2024-08-05T16:12:12"), OrderStatus.AWAITING_PAYMENT, u2);
		this.orderRepository.saveAll(Arrays.asList(o1u1, o1u2, o2u1, o2u2));

		Product p1 = new Product("IntelliJ IDEA", "IDE for development", 12.5);
		Product p2 = new Product("Eclipse", "IDE for development", 32.5);
		this.productRepository.saveAll(Arrays.asList(p1, p2));

		OrderItem oi1u1 = new OrderItem(o1u1, p1, 2, p1.getPrice());
		OrderItem oi2u1 = new OrderItem(o1u2, p2, 4, p2.getPrice());
		OrderItem oi1u2 = new OrderItem(o2u1, p2, 5, p2.getPrice());
		OrderItem oi2u2 = new OrderItem(o2u2, p1, 10, p1.getPrice());
		this.orderItemRepository.saveAll(Arrays.asList(oi1u1, oi2u1, oi1u2, oi2u2));

		o1u1.getITEMS().addAll(Arrays.asList(oi1u1, oi2u1));
		o1u2.getITEMS().addAll(Arrays.asList(oi1u1, oi2u1));
		o2u1.getITEMS().addAll(Arrays.asList(oi1u2, oi2u2));
		o2u2.getITEMS().addAll(Arrays.asList(oi1u2, oi2u2));
		this.orderRepository.saveAll(Arrays.asList(o1u1, o1u2, o2u1, o2u2));
	}
}

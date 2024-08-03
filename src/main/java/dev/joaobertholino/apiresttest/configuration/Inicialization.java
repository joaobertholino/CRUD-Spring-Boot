package dev.joaobertholino.apiresttest.configuration;

import dev.joaobertholino.apiresttest.models.Order;
import dev.joaobertholino.apiresttest.models.User;
import dev.joaobertholino.apiresttest.repositories.OrderRepository;
import dev.joaobertholino.apiresttest.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class Inicialization implements CommandLineRunner {
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;

	public Inicialization(UserRepository userRepository, OrderRepository orderRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Joao", "Bertholino", "joao@email.com");
		Order o1u1 = new Order(LocalDateTime.parse("2024-04-03T10:15:30"), u1);
		Order o1u2 = new Order(LocalDateTime.parse("2024-03-04T10:15:30"), u1);

		User u2 = new User("Ellen", "Sthefani", "ellen@email.com");
		Order o2u1 = new Order(LocalDateTime.parse("2024-08-05T13:34:12"), u2);
		Order o2u2 = new Order(LocalDateTime.parse("2024-08-05T16:12:12"), u2);

		this.userRepository.saveAll(Arrays.asList(u1, u2));
		this.orderRepository.saveAll(Arrays.asList(o1u1, o1u2, o2u1, o2u2));
	}
}

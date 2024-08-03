package dev.joaobertholino.apiresttest.models;

import dev.joaobertholino.apiresttest.models.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_ORDER")
public class Order implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotNull
	private LocalDateTime orderDate;

	@NotNull
	private OrderStatus status;

	@ManyToOne
	@NotNull
	private User client;

	public Order() {
	}

	public Order(LocalDateTime orderDate, OrderStatus status, User client) {
		this.orderDate = orderDate;
		this.status = status;
		this.client = client;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public @NotNull User getClient() {
		return client;
	}

	public void setClient(@NotNull User client) {
		this.client = client;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;
		return id.equals(order.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}

package dev.joaobertholino.apiresttest.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItem implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private final OrderItemPK id = new OrderItemPK();

	@NotNull
	private Integer amount;

	@NotNull
	private Double price;

	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer amount, Double price) {
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.amount = amount;
		this.price = price;
	}

	public OrderItemPK getId() {
		return id;
	}

	public @NotNull Integer getAmount() {
		return amount;
	}

	public void setAmount(@NotNull Integer amount) {
		this.amount = amount;
	}

	public @NotNull Double getPrice() {
		return price;
	}

	public void setPrice(@NotNull Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderItem orderItem = (OrderItem) o;
		return id.equals(orderItem.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}

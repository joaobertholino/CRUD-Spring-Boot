package dev.joaobertholino.apiresttest.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItem implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	private Integer amount;
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

	public void setId(OrderItemPK id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double DoubleSubTotal() {
		return this.amount * this.price;
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

package dev.joaobertholino.apiresttest.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class OrderItemPK implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private Order order;

	@ManyToOne
	@NotNull
	private Product product;

	public @NotNull Order getOrder() {
		return order;
	}

	public void setOrder(@NotNull Order order) {
		this.order = order;
	}

	public @NotNull Product getProduct() {
		return product;
	}

	public void setProduct(@NotNull Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderItemPK that = (OrderItemPK) o;
		return order.equals(that.order) && product.equals(that.product);
	}

	@Override
	public int hashCode() {
		int result = order.hashCode();
		result = 31 * result + product.hashCode();
		return result;
	}
}

package dev.joaobertholino.apiresttest.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	private String description;
	private Double price;

	@OneToMany(mappedBy = "id.product", cascade = CascadeType.ALL)
	private final Set<OrderItem> ITEMS = new HashSet<>();

	public Product() {
	}

	public Product(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<OrderItem> getITEMS() {
		return ITEMS;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;
		return id.equals(product.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}

package dev.joaobertholino.apiresttest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class User implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String email;

	@OneToMany(mappedBy = "client")
	private final Set<Order> ORDER_LIST = new HashSet<>();

	public User() {
	}

	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public @NotBlank String getFirstName() {
		return firstName;
	}

	public void setFirstName(@NotBlank String firstName) {
		this.firstName = firstName;
	}

	public @NotBlank String getLastName() {
		return lastName;
	}

	public void setLastName(@NotBlank String lastName) {
		this.lastName = lastName;
	}

	public @NotBlank String getEmail() {
		return email;
	}

	public void setEmail(@NotBlank String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;
		return id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}

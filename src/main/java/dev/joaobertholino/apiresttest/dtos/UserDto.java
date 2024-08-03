package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String email;

	@NotNull
	private Set<OrderDto> orderList;

	public UserDto() {
	}

	public UserDto(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.orderList = user.getOrderList().stream().map(order -> new OrderDto(order)).collect(Collectors.toSet());
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

	public Set<OrderDto> getOrderList() {
		return orderList;
	}
}

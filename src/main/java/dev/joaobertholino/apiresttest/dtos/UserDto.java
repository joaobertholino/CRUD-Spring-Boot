package dev.joaobertholino.apiresttest.dtos;

import dev.joaobertholino.apiresttest.models.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {
	private String firstName;
	private String lastName;
	private String email;
	private Set<OrderDto> orderList;

	public UserDto() {
	}

	public UserDto(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.orderList = user.getOrderList().stream().map(order -> new OrderDto(order)).collect(Collectors.toSet());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<OrderDto> getOrderList() {
		return orderList;
	}
}

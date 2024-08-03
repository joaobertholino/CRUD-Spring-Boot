package dev.joaobertholino.apiresttest.models.enums;

public enum OrderStatus {
	AWAITING_PAYMENT("AwaitingPayment"),
	PAYMENT("Payment"),
	SENT("Sent"),
	CANCELLED("Cancelled"),
	DELIVERED("Delivered");

	private final String value;

	OrderStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

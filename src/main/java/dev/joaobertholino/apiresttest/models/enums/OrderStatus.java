package dev.joaobertholino.apiresttest.models.enums;

public enum OrderStatus {
	AWAITING_PAYMENT("AwaitingPayment"),
	PAYMENT("Payment"),
	SENT("Sent"),
	CANCELLED("Cancelled"),
	DELIVERED("Delivered");

	private String value;

	OrderStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

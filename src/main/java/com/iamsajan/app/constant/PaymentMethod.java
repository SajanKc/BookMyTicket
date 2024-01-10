package com.iamsajan.app.constant;

public enum PaymentMethod {
    CASH(1, "CASH"),
    CARD(2, "CARD"),
    UPI(3, "UPI"),
    NET_BANKING(4, "NET_BANKING");

    private final int paymentMethodCode;
    private final String paymentMethod;

    PaymentMethod(int paymentMethodCode, String paymentMethod) {
        this.paymentMethodCode = paymentMethodCode;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}

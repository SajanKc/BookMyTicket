package com.iamsajan.app.constant;

public enum Status {
    AVAILABLE(1, "AVAILABLE"),
    NOT_AVAILABLE(2, "NOT_AVAILABLE"),
    BOOKED(3, "BOOKED"),
    CANCELLED(4, "CANCELLED");

    private final int statusCode;
    private final String status;

    Status(int statusCode, String status) {
        this.statusCode = statusCode;
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }
}

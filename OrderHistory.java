package com.foodApp.modules;


public class OrderHistory {
    private int orderHistoryId;
    private int orderId;
    private int userId;
    private float totalAmount;
    private String status;
    private String orderDate; // Added this field to match the database schema

    public OrderHistory() {
    }

    public OrderHistory(int orderHistoryId, int orderId, int userId, float totalAmount, String status, String orderDate) {
        this.orderHistoryId = orderHistoryId;
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate; // Initialize the new field
    }

    public OrderHistory(int orderId, int userId, float totalAmount, String status, String orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate; // Initialize the new field
    }

    public int getOrderHistoryId() {
        return orderHistoryId;
    }

    public void setOrderHistoryId(int orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", userId=" + userId
                + ", totalAmount=" + totalAmount + ", status=" + status + ", orderDate=" + orderDate + "]";
    }
}
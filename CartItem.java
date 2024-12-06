package com.foodApp.modules;



public class CartItem {
    private int itemId;
    private int restaurantId;
    private String menuName;
    private int quantity;
    private float price;
    private float subTotal;

    public CartItem() {
    }

    public CartItem(int itemId, int restaurantId, String menuName, int quantity, float price) {
        super();
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.menuName = menuName;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = this.price * this.quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    private void updateSubTotal() {
        this.subTotal = this.price * this.quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateSubTotal(); // Recalculate subtotal when quantity is updated
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        updateSubTotal(); // Recalculate subtotal when price is updated
    }

    @Override
    public String toString() {
        return itemId + " " + restaurantId + " " + menuName + " " + quantity + " " + price + " " + subTotal;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
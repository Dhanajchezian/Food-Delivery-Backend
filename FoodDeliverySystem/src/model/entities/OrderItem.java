package model.entities;

public class OrderItem {

    private FoodItem foodItem;
    private int quantity;
    private double subtotal;

    public OrderItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.subtotal = foodItem.getPrice() * quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = foodItem.getPrice() * quantity;
    }
}

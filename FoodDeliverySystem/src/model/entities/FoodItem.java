package model.entities;

public class FoodItem {
    private int foodId;
    private String foodName;
    private double price;

    public FoodItem(int foodId, String foodName, double price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    public String getname() {
    	return foodName;
    }
    
    public int getid() {
    	return foodId;
    }
}

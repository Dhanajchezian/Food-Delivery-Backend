package controller;

import model.entities.Restaurant;

public class RestaurantController {

    public Restaurant createRestaurant(int restaurantId, String name) {
        return new Restaurant(restaurantId, name);
    }

    public boolean isRestaurantActive(Restaurant restaurant) {
        return restaurant.isActive();
    }

    public String getRestaurantName(Restaurant restaurant) {
        return restaurant.getName();
    }
}

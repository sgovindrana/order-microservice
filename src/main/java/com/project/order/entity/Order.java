package com.project.order.entity;

import com.project.order.dto.FoodItemsDTO;
import com.project.order.dto.Restaurant;
import com.project.order.dto.UserDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemsDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;



    public Order(Integer orderId, List<FoodItemsDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO) {
        this.orderId = orderId;
        this.foodItemsList = foodItemsList;
        this.restaurant = restaurant;
        this.userDTO = userDTO;
    }

    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<FoodItemsDTO> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}

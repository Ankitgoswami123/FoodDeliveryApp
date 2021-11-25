package com.example.foodorderingapp.Models;

public class OrdersModel {
    int orderImage;
    String solditemName,price,orderNumber,soldQuantity;

    public String getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(String soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSolditemName() {
        return solditemName;
    }

    public void setSolditemName(String solditemName) {
        this.solditemName = solditemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrdersModel() {
    }

    public OrdersModel(int orderImage, String solditemName, String price, String orderNumber,String soldQuantity) {
        this.orderImage = orderImage;
        this.solditemName = solditemName;
        this.price = price;
        this.orderNumber = orderNumber;
        this.soldQuantity = soldQuantity;
    }
}

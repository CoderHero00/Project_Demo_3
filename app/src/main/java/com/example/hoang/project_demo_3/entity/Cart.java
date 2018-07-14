package com.example.hoang.project_demo_3.entity;

import java.util.HashMap;

public class Cart {
    private String userPhone;
    private String userFullName;
    private String shipName;
    private String address;
    private String shipPhone;
    private String note;
    private int totalPrice;
    private HashMap<Integer, com.example.hoang.project_demo_3.entity.CartItem> mapCart;

    public Cart() {
    }

    public Cart(String userPhone, String userFullName, String shipName, String shipPhone, String address, String note, int totalPrice, HashMap<Integer, com.example.hoang.project_demo_3.entity.CartItem> mapCart) {
        this.userPhone = userPhone;
        this.userFullName = userFullName;
        this.shipName = shipName;
        this.shipPhone = shipPhone;
        this.address = address;
        this.note = note;
        this.totalPrice = totalPrice;
        this.mapCart = mapCart;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HashMap<Integer, com.example.hoang.project_demo_3.entity.CartItem> getMapCart() {
        return mapCart;
    }

    public void setMapCart(HashMap<Integer, com.example.hoang.project_demo_3.entity.CartItem> mapCart) {
        this.mapCart = mapCart;
    }
}

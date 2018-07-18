package com.example.hoang.project_demo_3.entity;

import java.util.List;

public class Request {
    private String phone;
    private String name;
    private String address;
    private String total;
    private String status;
    private List<Order> list_Order;

    public Request() {
        this.status = "0";
    }

    public Request(String phone, String name, String address, String total, List<Order> list_Order) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.list_Order = list_Order;
        this.status = "0"; // 0: place - 1: Shipping - 2: Shipped.
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Order> getList_Order() {
        return list_Order;
    }

    public void setList_Order(List<Order> list_Order) {
        this.list_Order = list_Order;
    }
}

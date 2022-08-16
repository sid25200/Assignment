package com.example.Assignment.Model;

import org.springframework.data.annotation.Id;

public class TWCheckout {
    @Id
    private String checkoutId;
    private String resultId;
    private String requestId;
    private InsurerPremium insurerPremium;
    private Customer customer;
    private Vehicle vehicle;

    public TWCheckout(InsurerPremium insurerPremium, Customer customer, Vehicle vehicle) {
        this.insurerPremium = insurerPremium;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public InsurerPremium getInsurerPremium() {
        return insurerPremium;
    }

    public void setInsurerPremium(InsurerPremium insurerPremium) {
        this.insurerPremium = insurerPremium;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

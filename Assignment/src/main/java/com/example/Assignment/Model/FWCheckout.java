package com.example.Assignment.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FWCheckout")
public class FWCheckout {
    @Id
    private String checkoutId;

    private String resultId;

    private InsurerPremium insurerPremium;
    private String requestId;


    private Customer customer;
    private FWVehicle fwVehicle;
    public FWCheckout(InsurerPremium insurerPremium, Customer customer, FWVehicle fwVehicle) {
        this.insurerPremium = insurerPremium;
        this.customer = customer;
        this.fwVehicle = fwVehicle;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FWVehicle getFwVehicle() {
        return fwVehicle;
    }

    public void setFwVehicle(FWVehicle fwVehicle) {
        this.fwVehicle = fwVehicle;
    }
    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public InsurerPremium getInsurerPremium() {
        return insurerPremium;
    }

    public void setInsurerPremium(InsurerPremium insurerPremium) {
        this.insurerPremium = insurerPremium;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}

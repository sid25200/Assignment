package com.example.Assignment.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "InsurerPremiumList")
public class InsurerPremiumList {
   // private String requestId;
    private String vertical;
    private String model;
    private String make;
    private List<InsurerPremium> insurerPremiumList;

    public InsurerPremiumList(String vertical, String model, String make, List<InsurerPremium> insurerPremiumList) {
        this.vertical = vertical;
        this.model = model;
        this.make = make;
        this.insurerPremiumList = insurerPremiumList;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public List<InsurerPremium> getInsurerPremiumList() {
        return insurerPremiumList;
    }

    public void setInsurerPremiumList(List<InsurerPremium> insurerPremiumList) {
        this.insurerPremiumList = insurerPremiumList;
    }


}

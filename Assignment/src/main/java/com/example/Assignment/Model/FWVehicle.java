package com.example.Assignment.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FWVehicleRequest")
public class FWVehicle {
    private String requestId;
    private String vertical;
    private String model;
    private String make;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public FWVehicle(String requestId, String vertical, String model, String make) {
        this.requestId = requestId;
        this.vertical = vertical;
        this.model = model;
        this.make = make;
    }
}

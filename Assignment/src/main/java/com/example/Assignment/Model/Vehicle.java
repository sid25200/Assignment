package com.example.Assignment.Model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vehicle")
public class Vehicle {
    @Id
    private String requestId;

    @NotBlank(message = "Name may not be blank")
    private String vertical;
    private String model;
    private String make;


    public Vehicle(String vertical, String model, String make) {
        this.vertical = vertical;
        this.model = model;
        this.make = make;

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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}

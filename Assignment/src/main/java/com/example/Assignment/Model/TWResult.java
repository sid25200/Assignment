package com.example.Assignment.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TWResults")
public class TWResult {
    @Id
    private String resultId;
    private String requestId;
    private String insurerName;
    private Vehicle Vehicle;
    private InsurerPremium insurerPremium;

    public TWResult(com.example.Assignment.Model.Vehicle vehicle, InsurerPremium insurerPremium) {
        Vehicle = vehicle;
        this.insurerPremium = insurerPremium;
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

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public com.example.Assignment.Model.Vehicle getVehicle() {
        return Vehicle;
    }

    public void setVehicle(com.example.Assignment.Model.Vehicle vehicle) {
        Vehicle = vehicle;
    }

    public InsurerPremium getInsurerPremium() {
        return insurerPremium;
    }

    public void setInsurerPremium(InsurerPremium insurerPremium) {
        this.insurerPremium = insurerPremium;
    }
}

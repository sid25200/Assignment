package com.example.Assignment.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FWResults")
public class FWResult {


    @Id
    private String resultId;
    private String requestId;
    private String insurerName;

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    private FWVehicle fwVehicle;
    private InsurerPremium insurerPremium;

    public FWVehicle getFwVehicle() {
        return fwVehicle;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public void setFwVehicle(FWVehicle fwVehicle) {
        this.fwVehicle = fwVehicle;
    }

    public InsurerPremium getInsurerPremium() {
        return insurerPremium;
    }

    public void setInsurerPremium(InsurerPremium insurerPremium) {
        this.insurerPremium = insurerPremium;
    }

    public FWResult(FWVehicle fwVehicle, InsurerPremium insurerPremium) {
        this.fwVehicle = fwVehicle;
        this.insurerPremium = insurerPremium;
    }
}

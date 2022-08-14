package com.example.Assignment.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FWResults")
public class FWResult {
    private FWVehicle fwVehicle;
    private InsurerPremium insurerPremium;

    public FWVehicle getFwVehicle() {
        return fwVehicle;
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

package com.example.Assignment.Model;

public class Result {
    private FWVehicle fwVehicle;
    private InsurerPremiumList insurerPremiumList;

    public FWVehicle getFwVehicle() {
        return fwVehicle;
    }

    public void setFwVehicle(FWVehicle fwVehicle) {
        this.fwVehicle = fwVehicle;
    }

    public InsurerPremiumList getInsurerPremiumList() {
        return insurerPremiumList;
    }

    public void setInsurerPremiumList(InsurerPremiumList insurerPremiumList) {
        this.insurerPremiumList = insurerPremiumList;
    }

    public Result(FWVehicle fwVehicle, InsurerPremiumList insurerPremiumList) {
        this.fwVehicle = fwVehicle;
        this.insurerPremiumList = insurerPremiumList;
    }
}

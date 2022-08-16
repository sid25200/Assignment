package com.example.Assignment.Model;

public class TwoWheeler {
    private Vehicle vehicle;
    private InsurerPremiumList insurerPremiumList;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public InsurerPremiumList getInsurerPremiumList() {
        return insurerPremiumList;
    }

    public void setInsurerPremiumList(InsurerPremiumList insurerPremiumList) {
        this.insurerPremiumList = insurerPremiumList;
    }

    public TwoWheeler(Vehicle vehicle, InsurerPremiumList insurerPremiumList) {
        this.vehicle = vehicle;
        this.insurerPremiumList = insurerPremiumList;
    }
}


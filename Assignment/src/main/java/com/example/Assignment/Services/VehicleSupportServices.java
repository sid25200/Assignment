package com.example.Assignment.Services;

import com.example.Assignment.Model.FWVehicle;
import com.example.Assignment.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class VehicleSupportServices {


    public String createRequestId(String vertical) {
        String requestId = "";

        requestId += vertical;
        for (int value = 0; value < 4; value++) {
            int rand = (int) (Math.random() * 10);
            requestId += rand;
        }
        for (int value = 0; value < 4; value++) {
            requestId += randomChar();
        }
        return requestId;
    }

    private static char randomChar() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 'A');
    }

    public boolean validateVehicleData(Vehicle vehicle) {
        if (vehicle.getRequestId() == null || vehicle.getMake() == null || vehicle.getVertical() == null || vehicle.getModel() == null) {
            return false;
        }
        return true;
    }

    public boolean validateInput(FWVehicle fwVehicle) {
        return (fwVehicle.getVertical() == null || fwVehicle.getMake() == null || fwVehicle.getModel() == null);
    }
}

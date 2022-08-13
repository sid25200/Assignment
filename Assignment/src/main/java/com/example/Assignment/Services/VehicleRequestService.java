package com.example.Assignment.Services;

import com.example.Assignment.Model.FWVehicle;
import com.example.Assignment.Model.Vehicle;
import com.example.Assignment.Repository.FWVehicleRequestRepository;
import com.example.Assignment.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class VehicleRequestService {

    @Autowired
    private FWVehicleRequestRepository fwVehicleRequestRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    public String newVehicleRequest(FWVehicle fwVehicle){
        String createRequestId = "";
        //while (true) {
            createRequestId = createRequestId(fwVehicle.getVertical());
//            if (vehicleRequestController.getVehicleData(createRequestId,fwVehicle.getVertical()).isEmpty()) {
//                break;
//            }
        //}
        fwVehicle.setRequestId(createRequestId);
        if(fwVehicle.getVertical().equalsIgnoreCase("FW"))
            fwVehicleRequestRepository.insert(fwVehicle);
        else if (fwVehicle.getVertical().equalsIgnoreCase("TW")) {
            Vehicle vehicle = new Vehicle(fwVehicle.getRequestId(), fwVehicle.getVertical(), fwVehicle.getModel(), fwVehicle.getMake());
            vehicleRepository.insert(vehicle);
        }
        else {
            return "Data Missing";
        }
        return "successfully New Vehicle Request " + fwVehicle.getRequestId();
    }
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



    public List<FWVehicle> getAllFWVehicalRequest() {
        //List<FWVehicle> vehicleList= fwVehicleRequestRepository.findAll();
       //List <Vehicle> vehicles = vehicleList;
        return  fwVehicleRequestRepository.findAll();
    }

    public List<Vehicle> getAllTWVehicalRequest() {
        return vehicleRepository.findAll();
    }

    public Vehicle getTWVehicalDetailsByRequestId(String requestId) {
        return vehicleRepository.findByRequestId(requestId);
    }

    public FWVehicle getFWVehicalDetailsByRequestId(String requestId) {
        return  fwVehicleRequestRepository.findByRequestId(requestId);
    }


}

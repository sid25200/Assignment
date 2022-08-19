package com.example.Assignment.Services;

import com.example.Assignment.Constant.VehicalConstants;
import com.example.Assignment.Model.FWVehicle;
import com.example.Assignment.Model.Vehicle;
import com.example.Assignment.Repository.FWVehicleRequestRepository;
import com.example.Assignment.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class VehicleRequestService {

    @Autowired
    private FWVehicleRequestRepository fwVehicleRequestRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleSupportServices vehicleSupportServices;
    @Autowired
    private ResultService resultService;
    public String newVehicleRequest(FWVehicle fwVehicle){
        // create unique requestId
        String createRequestId = "";
        while (true) {
            createRequestId = vehicleSupportServices.createRequestId(fwVehicle.getVertical());
            if (getFWVehicalDetailsByRequestId(fwVehicle.getVertical(), createRequestId)==null) {
                break;
            }
        }
        fwVehicle.setRequestId(createRequestId);

        if(fwVehicle.getVertical().equalsIgnoreCase("FW")) {
            if(vehicleSupportServices.validateInput(fwVehicle))     return "Not Proper Input";
            // insert Vehicle Data
            fwVehicleRequestRepository.insert(fwVehicle);
            // Call insurer result Static Api
            resultService.getAllFWInsurerResultByRequestId(fwVehicle.getRequestId());
        }
        else if (fwVehicle.getVertical().equalsIgnoreCase("TW")) {
            Vehicle vehicle = new Vehicle(fwVehicle.getRequestId(), fwVehicle.getVertical(), fwVehicle.getModel(), fwVehicle.getMake());
            if(!vehicleSupportServices.validateVehicleData(vehicle))   return "Not Proper Input";
            vehicleRepository.insert(vehicle);
            resultService.getAllTWInsurerResultByRequestId(vehicle.getRequestId());
        }
        else {
            return "Data Missing";
        }
        return "successfully New Vehicle Request " + fwVehicle.getRequestId();
    }
    public List<Vehicle> getAllVehicalRequest(String vertical) {
        if(vertical.equalsIgnoreCase(VehicalConstants.TW))
            return vehicleRepository.findAll();
        else if(vertical.equalsIgnoreCase(VehicalConstants.FW)) {
            List<FWVehicle> fwVehicleList = fwVehicleRequestRepository.findAll();
            List<Vehicle> vehicleList = new ArrayList<>();
            for(int i=0;i<fwVehicleList.size();i++){
                vehicleList.add(new Vehicle(fwVehicleList.get(i).getRequestId(),fwVehicleList.get(i).getVertical(),fwVehicleList.get(i).getModel(),fwVehicleList.get(i).getMake()));
            }
            return vehicleList;
        }
        return null;
    }

    // All Four Wheeler Data
//
//    public List<FWVehicle> getAllFWVehicalRequest() {
//        return  fwVehicleRequestRepository.findAll();
//    }
//
//    // All Two Wheeler Data
//    public List<Vehicle> getAllTWVehicalRequest() {
//        return vehicleRepository.findAll();
//    }

    public FWVehicle getFWVehicalDetailsByRequestId(String vertical, String requestId) {
        if(vertical.equalsIgnoreCase(VehicalConstants.FW))
            return fwVehicleRequestRepository.findByRequestId(requestId);
        else if(vertical.equalsIgnoreCase(VehicalConstants.TW)){
            Vehicle vehicle = vehicleRepository.findByRequestId(requestId);//findByRequestId(requestId);
            if(vehicle == null)
                return null;
            return new FWVehicle(vehicle.getRequestId(),vehicle.getVertical(),vehicle.getModel(),vehicle.getMake());
        }
        return null;
    }


    // Specific Two Wheeler Data
//    public Vehicle getTWVehicalDetailsByRequestId(String requestId) {
//        return vehicleRepository.findByRequestId(requestId);
//    }
//    // Specific Four Wheeler Data
//    public  FWVehicle getFWVehicalDetailsByRequestId(String requestId) {
//        return  fwVehicleRequestRepository.findByRequestId(requestId);
//    }

}

package com.example.Assignment.Controller;

import com.example.Assignment.Model.FWVehicle;
import com.example.Assignment.Model.Vehicle;
import com.example.Assignment.Repository.FWVehicleRequestRepository;
import com.example.Assignment.Services.VehicleRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleRequestController {
    @Autowired
    private FWVehicleRequestRepository fwVehicleRequestRepository;
    @Autowired
    private VehicleRequestService vehicleRequestService;

    //save vehicle details and create 4 results
    @PostMapping("/api/vehicle/add/")
    public String addNewVehicleRequest(@RequestBody FWVehicle fwVehicle) {
            return vehicleRequestService.newVehicleRequest(fwVehicle);
    }

    @GetMapping("/api/vehicle/{vertical}")
    public List<Vehicle> getAllVehicalData(@PathVariable String vertical) {
            return vehicleRequestService.getAllVehicalRequest(vertical);
    }

//    @GetMapping("/api/vehicle/TW")
//    public List<Vehicle> getAllTWVehicalData() {
//            return vehicleRequestService.getAllTWVehicalRequest();
//    }
//    @GetMapping("/api/vehicle/FW")
//    public List<FWVehicle> getAllFWVehicleData() {
//        return vehicleRequestService.getAllFWVehicalRequest();
//    }

    @GetMapping("/api/vehicle/{vertical}/{requestId}")
    public FWVehicle getTWVehicalRequestDetails(@PathVariable String vertical, @PathVariable String requestId) {
        return vehicleRequestService.getFWVehicalDetailsByRequestId(vertical, requestId);
    }

//    @GetMapping("/api/vehicle/FW/{requestId}")
//    public FWVehicle getFWVehicalRequestDetails(@PathVariable String requestId) {
//        return vehicleRequestService.getFWVehicalDetailsByRequestId(requestId);
//    }
//    @GetMapping("/api/vehicle/TW/{requestId}")
//    public Vehicle getTWVehicalRequestDetails(@PathVariable String requestId) {
//        return vehicleRequestService.getTWVehicalDetailsByRequestId(requestId);
//    }

}

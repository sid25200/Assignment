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

    public VehicleRequestController() {
    }

    @PostMapping("/api/vehicle/add/")
    public String addNewVehicleRequest(@RequestBody FWVehicle fwVehicle) {
            return vehicleRequestService.newVehicleRequest(fwVehicle);
    }

    @GetMapping("/api/vehicle/TW")
    public List<Vehicle> getAllTWVehicalData() {
            return vehicleRequestService.getAllTWVehicalRequest();
    }
    @GetMapping("/api/vehicle/FW")
    public List<FWVehicle> getAllFWVehicleData() {
        return vehicleRequestService.getAllFWVehicalRequest();
    }
    @GetMapping("/api/vehicle/FW/{requestId}")
    public FWVehicle getFWVehicalRequestDetails(@PathVariable String requestId) {
        return vehicleRequestService.getFWVehicalDetailsByRequestId(requestId);
    }
    @GetMapping("/api/vehicle/TW/{requestId}")
    public Vehicle getTWVehicalRequestDetails(@PathVariable String requestId) {
        return vehicleRequestService.getTWVehicalDetailsByRequestId(requestId);
    }

}

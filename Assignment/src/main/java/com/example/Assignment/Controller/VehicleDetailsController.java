//package com.example.Assignment.Controller;
//
//import com.example.Assignment.Model.Vehicle;
//import com.example.Assignment.Repository.VehicleRepository;
//import com.example.Assignment.Services.VehicleSupportServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//public class VehicleDetailsController {
//    @Autowired
//    private VehicleRepository vehicleRepository;
//    @Autowired
//    private VehicleSupportServices vehicleSupportServices;
//
//    @PostMapping("/api/vehicle/add/")
//    public String addNewVehicleData(@RequestBody Vehicle vehicle) {
//        String createRequestId = "";
//        while (true) {
//            createRequestId = vehicleSupportServices.createRequestId(vehicle.getVertical());
//            if (getVehicleData(createRequestId).isEmpty()) {
//                break;
//            }
//        }
//        vehicle.setRequestId(createRequestId);
//        if (!vehicleSupportServices.validateVehicleData(vehicle)) {
//            return "Missing Vehicle Data";
//        }
//        vehicleRepository.save(vehicle);
//        return "Added New Vehicle Data " + vehicle.getRequestId();
//    }
//
//    @GetMapping("/api/vehicle/allData/{vertical}")
//    public List<Vehicle> getAllVehicleData(@PathVariable String vertical) {
//        return vehicleRepository.findAllByVertical(vertical);
//    }
//
//    @GetMapping("/api/vehicle/{id}")
//    public Optional<Vehicle> getVehicleData(@PathVariable String id) {
//        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
//        return vehicle;
//    }
//
//    @PutMapping("/api/vehicle/update/")
//    public Vehicle updateVehicleData(@RequestBody Vehicle vehicle) {
//        Vehicle vehicleData = null;
//        if (getVehicleData(vehicle.getRequestId()).isPresent()) {
//            vehicleData = vehicleRepository.findByRequestId(vehicle.getRequestId());
//            vehicleData.setVertical(vehicle.getVertical());
//            vehicleData.setMake(vehicle.getMake());
//            vehicleData.setModel(vehicle.getModel());
//            vehicleRepository.save(vehicleData);
//        }
//        return vehicleData;
//    }
//
//    @DeleteMapping("/api/vehicle/{id}")
//    public String deleteVehicleProfile(@PathVariable String id) {
//        if (getVehicleData(id).isEmpty()) {
//            return "Vehicle Data Not Found";
//        }
//        vehicleRepository.deleteById(id);
//        return "Vehicle Data Deleted Successfully";
//    }
//
//}

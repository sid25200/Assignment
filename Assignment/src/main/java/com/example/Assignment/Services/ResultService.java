package com.example.Assignment.Services;

import com.example.Assignment.Model.*;
import com.example.Assignment.Repository.FWResultsRepository;
import com.example.Assignment.Repository.FWVehicleRequestRepository;
import com.example.Assignment.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {


    @Autowired
    private InsurerPremiumListService insurerPremiumListService;


    // Vehicle details store in mongo repo
    @Autowired
    private FWVehicleRequestRepository fwVehicleRequestRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private TWResultSupportService twResultSupportService;
    @Autowired
    private FWResultSupportService fwResultSupportService;

    public void getAllFWInsurerResultByRequestId(String requestId) {
        FWVehicle fwVehicle = fwVehicleRequestRepository.findByRequestId(requestId);
        InsurerPremiumList insurerPremiumList =  insurerPremiumListService.getInsurerPremiumList(fwVehicle.getMake(),fwVehicle.getModel());
//        if(fwVehicle == null || insurerPremiumList == null )
//            return null;
        fwResultSupportService.storeAllFWResults(fwVehicle,insurerPremiumList,requestId);
        //return new Result(fwVehicle,insurerPremiumList);
    }

    public List<FWResult> getAllFWInsurerResult(String requestId) {
        return fwResultSupportService.findByOnlyRequestId(requestId);
    }
    public List<TWResult> getAllTWInsurerResult(String requestId) {
        return twResultSupportService.findByOnlyRequestId(requestId);
    }

    public void getAllTWInsurerResultByRequestId(String requestId) {
        Vehicle vehicle = vehicleRepository.findByRequestId(requestId);
        InsurerPremiumList insurerPremiumList =  insurerPremiumListService.getInsurerPremiumList(vehicle.getMake(),vehicle.getModel());
        twResultSupportService.storeAllTWResults(vehicle,insurerPremiumList,requestId);
    }
//        Vehicle vehicle = vehicleRequestService.getTWVehicalDetailsByRequestId(requestId);
//        InsurerPremiumList insurerPremiumList =  insurerPremiumListService.getInsurerPremiumList(requestId);
//        if(vehicle == null || insurerPremiumList == null )
//            return null;
//        twResultSupportService.storeAllTWResults(vehicle,insurerPremiumList,requestId);
//        return new TwoWheeler(vehicle,insurerPremiumList);
//    }
}

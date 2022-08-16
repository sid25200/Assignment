package com.example.Assignment.Services;

import com.example.Assignment.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    @Autowired
    private VehicleRequestService vehicleRequestService;
    @Autowired
    private InsurerPremiumListService insurerPremiumListService;
    @Autowired
    private FWResultSupportService fwResultSupportService;
    @Autowired
    private TWResultSupportService twResultSupportService;
    public Result getAllFWInsurerResultByRequestId(String requestId) {
        FWVehicle fwVehicle = vehicleRequestService.getFWVehicalDetailsByRequestId(requestId);
        InsurerPremiumList insurerPremiumList =  insurerPremiumListService.getInsurerPremiumList(requestId);
        if(fwVehicle == null || insurerPremiumList == null )
            return null;
        fwResultSupportService.storeAllFWResults(fwVehicle,insurerPremiumList,requestId);
        return new Result(fwVehicle,insurerPremiumList);
    }

    public TwoWheeler getAllTWInsurerResultByRequestId(String requestId) {
        Vehicle vehicle = vehicleRequestService.getTWVehicalDetailsByRequestId(requestId);
        InsurerPremiumList insurerPremiumList =  insurerPremiumListService.getInsurerPremiumList(requestId);
        if(vehicle == null || insurerPremiumList == null )
            return null;
        twResultSupportService.storeAllTWResults(vehicle,insurerPremiumList,requestId);
        return new TwoWheeler(vehicle,insurerPremiumList);
    }
}

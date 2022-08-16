package com.example.Assignment.Services;

import com.example.Assignment.Model.FWVehicle;
import com.example.Assignment.Model.InsurerPremiumList;
import com.example.Assignment.Model.Result;
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
    public Result getAllFWInsurerResultByRequestId(String requestId) {
        FWVehicle fwVehicle = vehicleRequestService.getFWVehicalDetailsByRequestId(requestId);
        InsurerPremiumList insurerPremiumList =  insurerPremiumListService.getInsurerPremiumList(requestId);
        if(fwVehicle == null || insurerPremiumList == null )
            return null;
        fwResultSupportService.storeAllFWResults(fwVehicle,insurerPremiumList,requestId);
        return new Result(fwVehicle,insurerPremiumList);
    }
}

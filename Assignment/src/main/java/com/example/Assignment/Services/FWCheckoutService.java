package com.example.Assignment.Services;

import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.FWCheckout;
import com.example.Assignment.Model.FWResult;
import com.example.Assignment.Model.FWVehicle;
import com.example.Assignment.Repository.FWCheckoutRepository;
import com.example.Assignment.Repository.FWResultsRepository;
import com.example.Assignment.Repository.FWVehicleRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FWCheckoutService {
    @Autowired
    private FWVehicleRequestRepository fwVehicleRequestRepository;
    @Autowired
    private FWResultsRepository fwResultsRepository;
    @Autowired
    private FWCheckoutRepository fwCheckoutRepository;
    public Optional<FWCheckout> getCheckoutDetailsByRequestIdAndInsurer(String requestId, String insurerName, Customer customer) {
        List<FWResult> fwResultList = fwResultsRepository.findBy(requestId);//.findBy(requestId,insurerName);
        FWResult fwResult = null;
        for(int iterator = 0; iterator < fwResultList.size() ; iterator ++ ) {
            fwResult = fwResultList.get(iterator);
            if(fwResult.getInsurerName().equalsIgnoreCase(insurerName))
                break;
        }
        //FWResult fwResult = fwResultList.fi;//fwResultList.get(0);
        if(fwResult == null)
            return null;
        FWCheckout fwCheckout = new FWCheckout(fwResult.getInsurerPremium(),customer,fwVehicleRequestRepository.findByRequestId(requestId));
        fwCheckout.setResultId(fwResult.getResultId());
        fwCheckoutRepository.insert(fwCheckout);
        return Optional.of(fwCheckout);
    }
}

package com.example.Assignment.Services;

import com.example.Assignment.Constant.CheckoutConstant;
import com.example.Assignment.Constant.VehicalConstants;
import com.example.Assignment.Model.*;
import com.example.Assignment.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServices {

    @Autowired
    private TWCheckoutRepository twCheckoutRepository;
    @Autowired
    private TWResultRepository twResultRepository;
    @Autowired
    private FWCheckoutRepository fwCheckoutRepository;
    @Autowired
    private FWResultsRepository fwResultsRepository;
    @Autowired
    private CheckoutSupportServices checkoutSupportServices;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private FWVehicleRequestRepository fwVehicleRequestRepository;
    public FWCheckout getCheckoutDetailsByRequestId(String vertical, String requestId) {
        if(vertical.equalsIgnoreCase(VehicalConstants.TW)) {
            TWCheckout twCheckout =  twCheckoutRepository.findByRequestId(requestId);
            if(twCheckout == null)  return null;
            return new FWCheckout(twCheckout.getCheckoutId(),twCheckout.getRequestId(),twCheckout.getInsurerPremium(),twCheckout.getRequestId(), twCheckout.getCustomer(),new FWVehicle(twCheckout.getVehicle().getRequestId(),twCheckout.getVehicle().getVertical(),twCheckout.getVehicle().getModel(),twCheckout.getVehicle().getMake()));
        }
        else if(vertical.equalsIgnoreCase(VehicalConstants.FW)) {
            return fwCheckoutRepository.findByRequestId(requestId);
        }
        return null;
    }

    public TWCheckout storeCheckoutDetailsByRequestIdAndResultId(String vertical, String requestId, String resultId, Customer customer) {
        if(vertical.equalsIgnoreCase(VehicalConstants.TW)) {
            TWResult twResult = twResultRepository.findByResultId(resultId);
            if(twResult == null) return null;
            if(!checkoutSupportServices.validateCustomerDetails(customer).equalsIgnoreCase(CheckoutConstant.VALID)) return null;

            TWCheckout twCheckout = new TWCheckout(twResult.getInsurerPremium(), customer,vehicleRepository.findByRequestId(requestId));
            twCheckout.setRequestId(requestId);
            twCheckout.setResultId(resultId);
            twCheckoutRepository.insert(twCheckout);
            return twCheckout;
        } else if (vertical.equalsIgnoreCase(VehicalConstants.FW)) {
            FWResult fwResult = fwResultsRepository.findByResultId(resultId);
            if(fwResult == null ) return null;
            if(!checkoutSupportServices.validateCustomerDetails(customer).equalsIgnoreCase(CheckoutConstant.VALID)) return null;

            FWCheckout fwCheckout =new FWCheckout(fwResult.getInsurerPremium(),customer, fwVehicleRequestRepository.findByRequestId(requestId));// null;
            fwCheckout.setRequestId(requestId);
            fwCheckout.setResultId(resultId);
//        fwCheckout.setCustomer(customer);
//        fwCheckout.setFwVehicle(fwVehicleRequestRepository.findByRequestId(requestId));
//        fwCheckout.setInsurerPremium(fwResult.getInsurerPremium());
            fwCheckoutRepository.insert(fwCheckout);
            return new TWCheckout(fwCheckout.getCheckoutId(),fwCheckout.getResultId(), fwCheckout.getRequestId(),fwCheckout.getInsurerPremium(),fwCheckout.getCustomer(), new Vehicle(fwCheckout.getFwVehicle().getRequestId(),fwCheckout.getFwVehicle().getVertical(),fwCheckout.getFwVehicle().getModel(),fwCheckout.getFwVehicle().getMake()));
        }
        return null;
    }
}

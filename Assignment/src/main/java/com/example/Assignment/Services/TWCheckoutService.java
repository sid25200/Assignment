package com.example.Assignment.Services;

import com.example.Assignment.Constant.CheckoutConstant;
import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.TWCheckout;
import com.example.Assignment.Model.TWResult;
import com.example.Assignment.Repository.TWCheckoutRepository;
import com.example.Assignment.Repository.TWResultRepository;
import com.example.Assignment.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TWCheckoutService {
    @Autowired
    private TWCheckoutRepository twCheckoutRepository;
    @Autowired
    private TWResultRepository twResultRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CheckoutSupportServices checkoutSupportServices;
    public TWCheckout getCheckoutDetailsByRequestIdAndInsurer(String requestId, String insurer, Customer customer) {
        List<TWResult> twResultList = twResultRepository.findByRequestId(requestId);
        TWResult twResult =null;
        for(int iterator=0 ;iterator < twResultList.size();iterator++) {
            twResult =twResultList.get(iterator);
            if(twResult.getInsurerName().equalsIgnoreCase(insurer)){
                break;
            }
        }
        if(twResult == null) return null;

        TWCheckout twCheckout = new TWCheckout(twResult.getInsurerPremium(),customer,vehicleRepository.findByRequestId(requestId));
        twCheckout.setRequestId(requestId);
        twCheckout.setResultId(twResult.getResultId());
        twCheckoutRepository.insert(twCheckout);
        return twCheckout;
    }

//    public TWCheckout getCheckoutDetailsByRequestIdAndResultId(String requestId, String resultId, Customer customer) {
//        TWResult twResult = twResultRepository.findByResultId(resultId);
//        if(twResult == null) return null;
//        if(!checkoutSupportServices.validateCustomerDetails(customer).equalsIgnoreCase(CheckoutConstant.VALID)) return null;
//
//        TWCheckout twCheckout = new TWCheckout(twResult.getInsurerPremium(), customer,vehicleRepository.findByRequestId(requestId));
//        twCheckout.setRequestId(requestId);
//        twCheckout.setResultId(resultId);
//        twCheckoutRepository.insert(twCheckout);
//        return twCheckout;
//    }
//    public TWCheckout getCheckoutDetailsByRequestIdAndResultId(String vertical, String requestId, String resultId, Customer customer) {
//
//    }
    public TWCheckout getCheckoutDetailsByRequestId(String requestId) {
        return twCheckoutRepository.findByRequestId(requestId);
    }

    public String updateCheckoutDetails(String requestId, String checkoutId, Customer customer) {
        String res = checkoutSupportServices.validateCustomerDetails(customer);
        if (res.equalsIgnoreCase(CheckoutConstant.VALID)) {
            TWCheckout twCheckout =null;
            twCheckout = twCheckoutRepository.findByCheckoutId(checkoutId);
            if(twCheckout!=null) {
                twCheckout.setCustomer(customer);
                return "Customer Details Updated Successfully ";
            }
            return "Checkout Id is not Correct";
        }
        return res;
    }
}

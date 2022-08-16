package com.example.Assignment.Services;

import com.example.Assignment.Constant.CheckoutConstant;
import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.FWCheckout;
import com.example.Assignment.Model.FWResult;
import com.example.Assignment.Repository.FWCheckoutRepository;
import com.example.Assignment.Repository.FWResultsRepository;
import com.example.Assignment.Repository.FWVehicleRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FWCheckoutService {
    @Autowired
    private FWVehicleRequestRepository fwVehicleRequestRepository;
    @Autowired
    private FWResultsRepository fwResultsRepository;
    @Autowired
    private FWCheckoutRepository fwCheckoutRepository;
    @Autowired
    private CheckoutSupportServices checkoutSupportServices;
    public FWCheckout getCheckoutDetailsByRequestIdAndInsurer(String requestId, String insurerName, Customer customer) {
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
        fwCheckout.setRequestId(requestId);
        fwCheckoutRepository.insert(fwCheckout);
        return fwCheckout;
    }

    public FWCheckout getCheckoutDetailsByRequestId(String requestId) {
        return fwCheckoutRepository.findByRequestId(requestId);
    }

    public String updateCheckoutDetails(String requestId, String checkoutId, Customer customer) {
        String res = checkoutSupportServices.validateCustomerDetails(customer);
        if(res.equalsIgnoreCase(CheckoutConstant.VALID)){
            FWCheckout fwCheckout = null;
            fwCheckout = fwCheckoutRepository.findByCheckoutId(checkoutId);
            if(fwCheckout != null) {
                fwCheckout.setCustomer(customer);
                //fwCheckoutRepository.save(fwCheckout);
                return "Customer Details Updated Successfully";
            }
            return "Checkout Id is not Correct";
        }
        return res;
    }
}

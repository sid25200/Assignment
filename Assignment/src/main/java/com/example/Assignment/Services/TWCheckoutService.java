package com.example.Assignment.Services;

import com.example.Assignment.Constant.CheckoutConstant;
import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.FWCheckout;
import com.example.Assignment.Model.TWCheckout;
import com.example.Assignment.Repository.TWCheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TWCheckoutService {
    @Autowired
    private TWCheckoutRepository twCheckoutRepository;
    @Autowired
    private CheckoutSupportServices checkoutSupportServices;
    public FWCheckout getCheckoutDetailsByRequestIdAndInsurer(String requestId, String insurer, Customer customer) {
        return null;
    }

    public FWCheckout getCheckoutDetailsByRequestIdAndResultId(String requestId, String resultId, Customer customer) {
        return null;
    }

    public FWCheckout getCheckoutDetailsByRequestId(String requestId) {
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

package com.example.Assignment.Services;

import com.example.Assignment.Constant.CheckoutConstant;
import com.example.Assignment.Model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CheckoutSupportServices {

    public String validateCustomerDetails(Customer customer) {
        String validResponce = CheckoutConstant.VALID;
        validResponce = validateCustomerName(customer.getCustName());
        if(!validResponce.equalsIgnoreCase(CheckoutConstant.VALID))
            return validResponce;
        validResponce = validateCustomerEmail(customer.getEmail());
        if(!validResponce.equalsIgnoreCase(CheckoutConstant.VALID))
            return validResponce;
        validResponce = validateCustomerPhoneNo(customer.getPhoneNo());
        return validResponce;
    }

    private String validateCustomerPhoneNo(String phoneNo) {
        if(phoneNo.matches(CheckoutConstant.PHONE_NO_REGEX) && !phoneNo.isEmpty() )
            return CheckoutConstant.VALID;
        return "Phone No is Not Proper or Null";
    }

    private String validateCustomerEmail(String email) {
            if (email.matches(CheckoutConstant.EMAIL_REGEX) && !email.isBlank())
                return CheckoutConstant.VALID;
        return "Email is Not Proper or Null";
    }

    private String validateCustomerName(String custName) {
        if(custName.isEmpty())
            return "Customer Name is not Present";
        return CheckoutConstant.VALID;
    }
}

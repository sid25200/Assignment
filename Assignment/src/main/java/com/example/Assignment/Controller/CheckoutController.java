package com.example.Assignment.Controller;

import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.FWCheckout;
import com.example.Assignment.Services.CheckoutServices;
import com.example.Assignment.Services.FWCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Assignment.Model.TWCheckout;
import com.example.Assignment.Services.TWCheckoutService;
@RestController
public class CheckoutController {
    @Autowired
    private FWCheckoutService fwCheckoutService;
    @Autowired
    private CheckoutServices checkoutServices;

//    @PostMapping("/api/vehicle/{vertical}/checkout/{requestId}/insurer/{resultId}")
//    public TWCheckout storeCheckoutDetailsByResultId(@PathVariable String vertical, @PathVariable String requestId, @PathVariable String resultId, @RequestBody Customer customer) {
//        return twCheckoutService.getCheckoutDetailsByRequestIdAndResultId(vertical,requestId, resultId,customer);
//    }
    @GetMapping("/api/vehicle/{vertical}/checkout/{requestId}")
    public FWCheckout getAllCheckoutDetails(@PathVariable String vertical, @PathVariable String requestId) {
        return checkoutServices.getCheckoutDetailsByRequestId(vertical, requestId);
    }
    @PostMapping("/api/vehicle/{vertical}/checkout/{requestId}/insurer/{resultId}")
    public TWCheckout storeCheckoutDetailsByResultId(@PathVariable String vertical, @PathVariable String requestId, @PathVariable String resultId, @RequestBody Customer customer) {
        return checkoutServices.storeCheckoutDetailsByRequestIdAndResultId(vertical,requestId, resultId, customer);
    }
}

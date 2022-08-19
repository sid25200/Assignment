package com.example.Assignment.Controller;

import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.FWCheckout;
import com.example.Assignment.Services.FWCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FWCheckoutController {
    @Autowired
    private FWCheckoutService fwCheckoutService;


    @PostMapping("/api/vehicle/FW/checkout/{requestId}/{insurer}")
    public FWCheckout storeCheckoutDetails(@PathVariable String requestId, @PathVariable String insurer, @RequestBody Customer customer) {
        return fwCheckoutService.getCheckoutDetailsByRequestIdAndInsurer(requestId, insurer,customer);
    }
//    @PostMapping("/api/vehicle/FW/checkout/{requestId}/insurer/{resultId}")
//    public FWCheckout storeCheckoutDetailsByResultId(@PathVariable String requestId, @PathVariable String resultId, @RequestBody Customer customer) {
//        return fwCheckoutService.getCheckoutDetailsByRequestIdAndResultId(requestId, resultId,customer);
//    }
//    @GetMapping("/api/vehicle/FW/checkout/{requestId}")
//    public FWCheckout getAllCheckoutDetails(@PathVariable String requestId) {
//        return fwCheckoutService.getCheckoutDetailsByRequestId(requestId);
//    }
    @PutMapping("/api/vehicle/FW/checkout/{requestId}/{checkoutId}")
    public String updateFWCheckoutDetails(@PathVariable String requestId, @PathVariable String checkoutId,@RequestBody Customer customer) {
        return fwCheckoutService.updateCheckoutDetails(requestId,checkoutId,customer);
    }
}

package com.example.Assignment.Controller;

import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.TWCheckout;
import com.example.Assignment.Services.TWCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class TWCheckoutController {
    @Autowired
    private TWCheckoutService twCheckoutService;


    @PostMapping("/api/vehicle/TW/checkout/{requestId}/{insurer}")
    public TWCheckout storeCheckoutDetails(@PathVariable String requestId, @PathVariable String insurer, @RequestBody Customer customer) {
        return twCheckoutService.getCheckoutDetailsByRequestIdAndInsurer(requestId, insurer,customer);
    }
    @PostMapping("/api/vehicle/TW/checkout/{requestId}/insurer/{resultId}")
    public TWCheckout storeCheckoutDetailsByResultId(@PathVariable String requestId, @PathVariable String resultId, @RequestBody Customer customer) {
        return twCheckoutService.getCheckoutDetailsByRequestIdAndResultId(requestId, resultId,customer);
    }
    @GetMapping("/api/vehicle/TW/checkout/{requestId}")
    public TWCheckout getAllCheckoutDetails(@PathVariable String requestId) {
        return twCheckoutService.getCheckoutDetailsByRequestId(requestId);
    }
    @PutMapping("/api/vehicle/TW/checkout/{requestId}/{checkoutId}")
    public String updateFWCheckoutDetails(@PathVariable String requestId, @PathVariable String checkoutId,@RequestBody Customer customer) {
        return twCheckoutService.updateCheckoutDetails(requestId,checkoutId,customer);
    }
}

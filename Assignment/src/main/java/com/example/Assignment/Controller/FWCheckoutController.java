package com.example.Assignment.Controller;

import com.example.Assignment.Model.Customer;
import com.example.Assignment.Model.FWCheckout;
import com.example.Assignment.Services.FWCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FWCheckoutController {
    @Autowired
    private FWCheckoutService fwCheckoutService;


    @PostMapping("/api/vehicle/FW/checkout/{requestId}/{insurer}")
    public Optional<FWCheckout> storeCheckoutDetails(@PathVariable String requestId, @PathVariable String insurer, @RequestBody Customer customer) {
        return fwCheckoutService.getCheckoutDetailsByRequestIdAndInsurer(requestId, insurer,customer);
    }
}

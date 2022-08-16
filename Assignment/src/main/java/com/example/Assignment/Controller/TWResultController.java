package com.example.Assignment.Controller;

import com.example.Assignment.Model.TwoWheeler;
import com.example.Assignment.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TWResultController {

    @Autowired
    private ResultService resultService;
    @GetMapping("/api/vehicle/TW/results/{requestId}")
    public TwoWheeler getAllTWInsurerResult(@PathVariable String requestId) {
        return resultService.getAllTWInsurerResultByRequestId(requestId);
    }
}

package com.example.Assignment.Controller;

import com.example.Assignment.Model.Result;
import com.example.Assignment.Repository.FWResultsRepository;
import com.example.Assignment.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FWResultController {
    @Autowired
    private FWResultsRepository fwResultsRepository;
    @Autowired
    private ResultService resultService;


    @GetMapping("/api/vehicle/FW/results/{requestId}")
    public Result getAllFWInsurerResult(@PathVariable String requestId){
        return resultService.getAllFWInsurerResultByRequestId(requestId);
    }

}

package com.example.Assignment.Controller;

import com.example.Assignment.Model.FWResult;
import com.example.Assignment.Model.TWResult;
import com.example.Assignment.Repository.FWResultsRepository;
import com.example.Assignment.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FWResultController {

    @Autowired
    private ResultService resultService;


    @GetMapping("/api/vehicle/FW/results/{requestId}")
    public List<FWResult> getAllFWInsurerResult(@PathVariable String requestId){
        return resultService.getAllFWInsurerResult(requestId);
    }
//    @GetMapping("/api/vehicle/TW/results/{requestId}")
//    public List<TWResult> getAllTWInsurerResult(@PathVariable String requestId){
//        return resultService.getAllTWInsurerResult(requestId);
//    }
}

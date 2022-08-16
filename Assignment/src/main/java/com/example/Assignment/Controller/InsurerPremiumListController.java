package com.example.Assignment.Controller;

import com.example.Assignment.Model.InsurerPremiumList;
import com.example.Assignment.Repository.InsurerPremiumListRepository;
import com.example.Assignment.Services.InsurerPremiumListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InsurerPremiumListController {

    @Autowired
    private InsurerPremiumListRepository insurerPremiumListRepository;

    @Autowired
    private InsurerPremiumListService insurerPremiumListService;

    @PostMapping("/api/insurerPremium/add/")
    public String addInsurerPremium(@RequestBody InsurerPremiumList insurerPremiumList){
        return insurerPremiumListService.addInsurerPremiumList(insurerPremiumList);
    }

//    @GetMapping("/api/insurerPremium/get/{requestId}")
//    public InsurerPremiumList getInsurerPremiumByRequestId(@PathVariable String requestId){
//        return insurerPremiumListService.getInsurerPremiumList(requestId);
//    }


}

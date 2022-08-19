package com.example.Assignment.Services;

import com.example.Assignment.Model.*;
import com.example.Assignment.Repository.TWResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TWResultSupportService {
    @Autowired
    private TWResultRepository twResultRepository;
    public void storeAllTWResults(Vehicle vehicle, InsurerPremiumList insurerPremiumList, String requestId) {
        List<InsurerPremium> insurerPremiumList1 = insurerPremiumList.getInsurerPremiumList();
        List<TWResult> twResultList = new ArrayList<>();
        for (int i=0;i<insurerPremiumList1.size();i++) {
            InsurerPremium insurerPremium = insurerPremiumList1.get(i);
            TWResult twResult = new TWResult();
            //new TWResult(vehicle, insurerPremium);
            twResult.setVehicle(vehicle);
            twResult.setInsurerPremium(insurerPremium);
            twResult.setInsurerName(insurerPremium.getInsurerName());
            twResult.setRequestId(requestId);
            twResultList.add(i,twResult);
        }
        twResultRepository.insert(twResultList);
    }

    public List<TWResult> findByOnlyRequestId(String requestId) {
        return twResultRepository.findAll();
    }
}

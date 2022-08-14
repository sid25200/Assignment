package com.example.Assignment.Services;

import com.example.Assignment.Model.FWResult;
import com.example.Assignment.Model.FWVehicle;
import com.example.Assignment.Model.InsurerPremium;
import com.example.Assignment.Model.InsurerPremiumList;
import com.example.Assignment.Repository.FWResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FWResultSupportService {
    @Autowired
    private FWResultsRepository fwResultsRepository;
    public void storeAllFWResults(FWVehicle fwVehicle, InsurerPremiumList insurerPremiumList) {

        List<InsurerPremium> insurerPremiumList1 = insurerPremiumList.getInsurerPremiumList();
        List<FWResult> fwResultList = new ArrayList<>();

        for (int i=0;i<insurerPremiumList1.size();i++) {
            InsurerPremium insurerPremium = insurerPremiumList1.get(i);
            FWResult fwResult = new FWResult(fwVehicle, insurerPremium);
            fwResultList.add(i,fwResult);
        }

        fwResultsRepository.insert(fwResultList);
    }
}

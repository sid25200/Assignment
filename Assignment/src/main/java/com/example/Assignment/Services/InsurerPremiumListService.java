package com.example.Assignment.Services;

import com.example.Assignment.Model.InsurerPremiumList;
import com.example.Assignment.Repository.InsurerPremiumListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsurerPremiumListService {

    @Autowired
    private InsurerPremiumListRepository insurerPremiumListRepository;
    public String addInsurerPremiumList(InsurerPremiumList insurerPremiumList) {
        if(insurerPremiumList.getRequestId().isEmpty())
            return "Missing Data";
        insurerPremiumListRepository.insert(insurerPremiumList);
        return "Added Insurer Premium Data "+ insurerPremiumList.getRequestId()+" "+insurerPremiumList.getInsurerPremiumList();
    }

    public InsurerPremiumList getInsurerPremiumList(String requestId) {
        return insurerPremiumListRepository.findByRequestId(requestId);
    }
}

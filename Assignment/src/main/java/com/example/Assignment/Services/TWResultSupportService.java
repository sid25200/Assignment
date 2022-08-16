package com.example.Assignment.Services;

import com.example.Assignment.Model.InsurerPremiumList;
import com.example.Assignment.Model.Vehicle;
import com.example.Assignment.Repository.TWResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TWResultSupportService {
    @Autowired
    private TWResultRepository twResultRepository;
    public void storeAllTWResults(Vehicle vehicle, InsurerPremiumList insurerPremiumList, String requestId) {
    }
}

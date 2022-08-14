package com.example.Assignment.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "InsurerPremiumList")
public class InsurerPremiumList {
    private String requestId;

    private List<InsurerPremium> insurerPremiumList;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<InsurerPremium> getInsurerPremiumList() {
        return insurerPremiumList;
    }

    public void setInsurerPremiumList(List<InsurerPremium> insurerPremiumList) {
        this.insurerPremiumList = insurerPremiumList;
    }

    public InsurerPremiumList(String requestId, List<InsurerPremium> insurerPremiumList) {
        this.requestId = requestId;
        this.insurerPremiumList = insurerPremiumList;
    }
}

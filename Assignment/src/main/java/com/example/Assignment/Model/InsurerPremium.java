package com.example.Assignment.Model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InsurerPremium")
public class InsurerPremium {
    public String insurerName;
    public Integer premium;

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public Integer getPremium() {
        return premium;
    }

    public void setPremium(Integer premium) {
        this.premium = premium;
    }

    public InsurerPremium(String insurerName, Integer premium) {
        this.insurerName = insurerName;
        this.premium = premium;
    }
}

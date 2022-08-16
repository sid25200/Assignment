package com.example.Assignment.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {
    public String custName;
    public String email;
    public String phoneNo;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Customer(String custName, String email, String phoneNo) {
        this.custName = custName;
        this.email = email;
        this.phoneNo = phoneNo;
    }
}

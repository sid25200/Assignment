package com.example.Assignment.Repository;

import com.example.Assignment.Model.FWVehicle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FWVehicleRequestRepository extends MongoRepository<FWVehicle,String> {
    FWVehicle findByRequestId(String requestId);
}

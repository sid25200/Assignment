package com.example.Assignment.Repository;

import com.example.Assignment.Model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    Vehicle findByRequestId(String requestId);
}

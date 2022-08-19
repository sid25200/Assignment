package com.example.Assignment.Repository;

import com.example.Assignment.Model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    //Vehicle findByRequestId(String requestId);

    List<Vehicle> findAllByVertical(String vertical);

    Vehicle findByRequestId(String requestId);
}

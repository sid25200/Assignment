package com.example.Assignment.Repository;

import com.example.Assignment.Model.TWResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TWResultRepository extends MongoRepository<TWResult, String> {

    List<TWResult> findByRequestId(String requestId);
}

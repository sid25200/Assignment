package com.example.Assignment.Repository;

import com.example.Assignment.Model.FWResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FWResultsRepository extends MongoRepository<FWResult,String> {
}

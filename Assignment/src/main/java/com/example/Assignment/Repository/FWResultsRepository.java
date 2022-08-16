package com.example.Assignment.Repository;

import com.example.Assignment.Model.FWResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FWResultsRepository extends MongoRepository<FWResult,String> {

    @Query()
    List<FWResult> findBy(String param1);

    FWResult findOneBy(String requestId, String insurerName);

    List<FWResult> findByRequestId(String requestId);

    FWResult findByResultId(String resultId);
}

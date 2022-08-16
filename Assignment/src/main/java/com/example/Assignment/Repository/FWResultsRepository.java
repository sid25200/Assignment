package com.example.Assignment.Repository;

import com.example.Assignment.Model.FWResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FWResultsRepository extends MongoRepository<FWResult,String> {
    //FWResult findByRequestIdAndInsurerName();
    @Query()
    List<FWResult> findBy(String param1);

    FWResult findOneBy(String requestId, String insurerName);

    //FWResult findByrequestIdAndinsurerName(String requestId);
    //FWResult findByRequestIdAndInsurerName(String , String );
}

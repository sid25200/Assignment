package com.example.Assignment.Repository;
import com.example.Assignment.Model.TWResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TWResultRepository extends MongoRepository<TWResult, String> {

    List<TWResult> findByRequestId(String requestId);

    TWResult findByResultId(String resultId);
//    @Query("{ 'requestId' : ?0 }")
//    List<TWResult> findBy(String param1);
//
//    List<TWResult> findALLByRequestId(String requestId);
}

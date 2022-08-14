package com.example.Assignment.Repository;

import com.example.Assignment.Model.InsurerPremiumList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsurerPremiumListRepository extends MongoRepository<InsurerPremiumList,String> {
    InsurerPremiumList findByRequestId(String requestId);
}

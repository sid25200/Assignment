package com.example.Assignment.Repository;

import com.example.Assignment.Model.FWCheckout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
//@EnableMongoRepositories
public interface FWCheckoutRepository extends MongoRepository<FWCheckout,String> {

}

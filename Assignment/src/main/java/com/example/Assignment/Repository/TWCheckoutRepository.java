package com.example.Assignment.Repository;

import com.example.Assignment.Model.FWCheckout;
import com.example.Assignment.Model.TWCheckout;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TWCheckoutRepository extends MongoRepository<TWCheckout, String> {
    TWCheckout findByRequestId(String requestId);

    TWCheckout findByCheckoutId(String checkoutId);
}

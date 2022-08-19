package com.example.Assignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "TWResults")
public class TWResult {
    @Id
    private String resultId;
    private String requestId;
    private String insurerName;
    private Vehicle vehicle;
    private InsurerPremium insurerPremium;

}

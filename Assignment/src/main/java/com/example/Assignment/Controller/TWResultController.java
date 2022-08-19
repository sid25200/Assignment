//package com.example.Assignment.Controller;
//
//import com.example.Assignment.Model.TWResult;
//import com.example.Assignment.Services.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class TWResultController {
//
//    @Autowired
//    private ResultService resultService;
////    @GetMapping("/api/vehicle/TW/results/{requestId}")
////    public List<TWResult> getAllTWInsurerResult(@PathVariable String requestId){
////        return resultService.getAllTWInsurerResult(requestId);
////    }
//    @GetMapping("/api/vehicle/{vertical}/results/{requestId}")
//    public List<TWResult> getAllTWInsurerResult(@PathVariable String vertical, @PathVariable String requestId){
//        return resultService.getAllInsurerResult(vertical,requestId);
//    }
//}

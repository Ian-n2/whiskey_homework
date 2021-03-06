package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

//    @GetMapping
//    public ResponseEntity<List<Whisky>> getAllWhiskys(){
//        return new ResponseEntity<>(whiskyRepository.findAll(),HttpStatus.OK);
//    }

    @GetMapping()
    public ResponseEntity findWhiskyByYear(@RequestParam(name = "year", required = false) Integer year){
        if( year != null){
            return new ResponseEntity(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/specific")
    public ResponseEntity findWhiskyByDistilleryNameAndAge(@RequestParam(name = "distilleryName", required = false)String distilleryName,
                                                           @RequestParam(name = "age", required = false) Integer age) {
        if (distilleryName != null && age != null) {
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryNameAndAge(distilleryName, age), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/region")
    public ResponseEntity findWhiskyByDistilleryRegion(@RequestParam(name = "distilleryRegion", required = false)String distilleryRegion){
        if (distilleryRegion != null){
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryRegion(distilleryRegion), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }
}

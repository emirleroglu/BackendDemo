package com.emirleroglu.backenddemo.controller;

import com.emirleroglu.backenddemo.models.Trip;
import com.emirleroglu.backenddemo.services.TripService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Trip Api Documentation")
public class TripController {

    @Autowired
    TripService myService;
    @ApiOperation(value = "returns all trip objects")
    @GetMapping("/trips")
    public ResponseEntity<List<Trip>> getTripAll() {
        return new ResponseEntity<>(myService.getTripAll(), HttpStatus.OK);
    }
}

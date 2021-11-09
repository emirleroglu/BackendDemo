package com.emirleroglu.backenddemo.controller;

import com.emirleroglu.backenddemo.models.Trip;
import com.emirleroglu.backenddemo.services.TripService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Trip Api Documentation")
@CrossOrigin
public class TripController {

    @Autowired
    TripService myService;

    @ApiOperation(value = "returns all trip objects")
    @GetMapping("/trips")
    public ResponseEntity<List<Trip>> getTripAll() {
        return new ResponseEntity<>(myService.getTripAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add trip api endpoint")
    @PostMapping("/addTrip")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {

        if (trip == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            myService.addTrip(trip);
            return new ResponseEntity<>(trip, HttpStatus.CREATED);
        }


    }

    @ApiOperation(value = "getting trip by id")
    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable("id")long id) {
        if (myService.getTripById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(myService.getTripById(id),HttpStatus.OK);
        }

    }
}

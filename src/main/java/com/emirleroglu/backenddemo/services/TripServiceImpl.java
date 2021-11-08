package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {
    List<Trip> myList = new ArrayList<Trip>();
    List<String> stations = new ArrayList<>();
    HashMap dayAndTime = new HashMap<String, String>();


    @Override
    public List<Trip> getTripAll() {
        return myList;
    }

    @Override
    public void addTrip(Trip trip) {
        myList.add(trip);


    }

    @Override
    public Trip getTripById(long id) {
        List<Trip> result = myList.stream().filter(x -> Objects.equals(x.getId(), id)).collect(Collectors.toList());
        return result.get(0);

    }

    // public List<Trip> getTripByStation(String station) {
    //     List<Trip> result = myList.stream().filter(x -> Objects.equals(x.getStation().stream()
    //             .filter( y-> Objects.equals(y,station)).collect(Collectors.toList())),station).collect(Collectors.toList());
    // }


}

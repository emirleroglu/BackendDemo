package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService{
    List<Trip> myList = new ArrayList<Trip>();
    List<String> stations = new ArrayList<>();
    List<String> time = new ArrayList<>();


    @Override
    public List<Trip> getTripAll() {
        if (stations.isEmpty()){
            stations.add("Göztepe");
            stations.add("Acıbadem");
        }
        if (time.isEmpty()){
            time.add("Pazartesi");
        }


        myList.add(new Trip(1L,"20170301046@dogus.edu.tr",stations,time));
        return myList;
    }


}

package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TripServiceImpl implements TripService{
    List<Trip> myList = new ArrayList<Trip>();
    List<String> stations = new ArrayList<>();
    HashMap dayAndTime = new HashMap<String,String>();


    @Override
    public List<Trip> getTripAll() {
        if (stations.isEmpty()){
            stations.add("Göztepe");
            stations.add("Acıbadem");
        }
        if (dayAndTime.isEmpty()){
            dayAndTime.put("Pazartesi","13.00");
        }


        myList.add(new Trip(1L,"20170301046@dogus.edu.tr",stations,dayAndTime));
        return myList;
    }


}

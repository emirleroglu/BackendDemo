package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.Trip;

import java.util.List;

public interface TripService {

    public List<Trip> getTripAll();

    public void addTrip(Trip trip);

    public Trip getTripById(long id);
}

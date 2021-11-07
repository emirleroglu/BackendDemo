package com.emirleroglu.backenddemo.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "Trip api documentation",description = "this is a demo api created for writing a frontend")
public class Trip {
    @ApiModelProperty(value = "Unique id field of trip object")
    private Long id;
    @ApiModelProperty(value = "emailAddress field of trip object")
    private String email;
    @ApiModelProperty(value = "Station list of trip object")
    private List<String> station;
    @ApiModelProperty(value = "Collection days and time of trip object")
    private HashMap<String,String> dayAndTimeCollection;

    public Trip() {
    }

    public Trip(Long id, String email, List<String> station, HashMap<String, String> dayAndTimeCollection) {
        this.id = id;
        this.email = email;
        this.station = station;
        this.dayAndTimeCollection = dayAndTimeCollection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getStation() {
        return station;
    }

    public void setStation(List<String> station) {
        this.station = station;
    }


    public HashMap<String, String> getDayAndTimeCollection() {
        return dayAndTimeCollection;
    }

    public void setDayAndTimeCollection(HashMap<String, String> dayAndTimeCollection) {
        this.dayAndTimeCollection = dayAndTimeCollection;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", station=" + station +
                ", dayAndTimeCollection=" + dayAndTimeCollection +
                '}';
    }
}

package com.emirleroglu.backenddemo.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "Trip api documentation",description = "this is a demo api created for writing a frontend")
public class Trip {
    @ApiModelProperty(value = "Unique id field of trip object")
    private Long id;
    @ApiModelProperty(value = "emailAddress field of trip object")
    private String email;
    @ApiModelProperty(value = "Station list of trip object")
    private List<String> station;
    @ApiModelProperty(value = "day list of trip object")
    private List<String> time;

    public Trip() {
    }

    public Trip(Long id, String email, List<String> station, List<String> time) {
        this.id = id;
        this.email = email;
        this.station = station;
        this.time = time;
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

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", station=" + station +
                ", time=" + time +
                '}';
    }
}

package com.entgra.task1.restdeviceapi.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.Date;

@EntityScan
public class Device {
    public enum status{
        enrolled,
        active,
        inactive

    }

    private long id;
    private String name;
    private status status;
    private String model;
    private Date enrolledTime;

    public Date getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(Date enrolledTime) {
        this.enrolledTime = enrolledTime;
    }

    public void setStatus(Device.status status) {
        this.status = status;
    }

    public Device.status getStatus() {
        return status;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
       this.name =  name;
    }

    public Device() {
    }

    public Device(long id, String name,  String model, status status, Date enrolledTime) {
        this.enrolledTime = enrolledTime;
        this.id = id;
        this.name = name;
        this.status = status;
        this.model = model;
    }
}

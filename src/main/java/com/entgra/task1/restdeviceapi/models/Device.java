package com.entgra.task1.restdeviceapi.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

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

    public Device(long id, String name,  String model, status status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.model = model;
    }
}

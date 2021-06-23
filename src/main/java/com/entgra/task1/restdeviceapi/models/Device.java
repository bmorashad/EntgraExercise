package com.entgra.task1.restdeviceapi.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Device {

    private long id;
    private String name;
    private int status;
    private String model;


    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public String getModel() {
        return model;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
       this.name =  name;
    }

    public Device() {
    }

    public Device(long id, String name,  String model, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.model = model;
    }
}

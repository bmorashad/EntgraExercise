package com.entgra.task1.restdeviceapi.models.dto;

public class DeviceDTO {



    private long id;
    private String name;
    private int status;
    private String model;

    public void setId(long id) {
        this.id = id;
    }
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

    public DeviceDTO() {
    }

    public DeviceDTO(long id, String name,  String model, int status) {
        this.name = name;
        this.status = status;
        this.model = model;
    }
}

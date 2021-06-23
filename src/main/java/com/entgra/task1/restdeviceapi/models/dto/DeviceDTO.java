package com.entgra.task1.restdeviceapi.models.dto;

import com.entgra.task1.restdeviceapi.models.Device;

public class DeviceDTO {
    private long id;
    private String name;


    private Device.status status;
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

    public Device.status getStatus() {
        return status;
    }
    public void setStatus(Device.status status) {
        this.status = status;
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

    public DeviceDTO() {
    }

    public DeviceDTO(long id, String name,  String model, Device.status status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.model = model;
    }
}

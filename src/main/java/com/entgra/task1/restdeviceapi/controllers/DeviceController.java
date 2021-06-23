package com.entgra.task1.restdeviceapi.controllers;

import com.entgra.task1.restdeviceapi.models.dto.DeviceDTO;
import com.entgra.task1.restdeviceapi.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/device")
public class DeviceController {
    @Autowired
    IDeviceService deviceService;

    @GetMapping()
    public List<DeviceDTO> getAll() {
        return deviceService.findAll();
    }

    @GetMapping("/{id}")
    public DeviceDTO getById(@PathVariable("id") long id) {
        return deviceService.findById(id);
    }

    @PutMapping()
    public DeviceDTO updateById(@RequestBody() DeviceDTO device) {
        return deviceService.updateDeviceById(device);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id) {
        return deviceService.deleteDeviceById(id);
    }

    @PostMapping()
    public DeviceDTO create(@RequestBody() DeviceDTO device) {
        boolean created = deviceService.createDevice(device);
        if(created) {
            return device;
        }
        return null;
    }
}

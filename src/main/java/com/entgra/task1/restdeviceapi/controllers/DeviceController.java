package com.entgra.task1.restdeviceapi.controllers;

import com.entgra.task1.restdeviceapi.models.Device;
import com.entgra.task1.restdeviceapi.models.dto.DeviceDTO;
import com.entgra.task1.restdeviceapi.service.IDeviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
    public ObjectNode getById(@PathVariable("id") long id) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        DeviceDTO device = deviceService.findById(id);
        if(device != null) {
            data.set("device", mapper.valueToTree(device));
        }
        return data;
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

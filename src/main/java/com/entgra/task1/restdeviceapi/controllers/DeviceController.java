package com.entgra.task1.restdeviceapi.controllers;

import com.entgra.task1.restdeviceapi.models.Device;
import com.entgra.task1.restdeviceapi.models.dto.DeviceDTO;
import com.entgra.task1.restdeviceapi.service.IDeviceService;
import com.entgra.task1.restdeviceapi.utils.APIResponse;
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
    public JsonNode getAll() {
        return APIResponse.createSuccessResponse(deviceService.findAll());
    }

    @GetMapping("/{id}")
    public JsonNode getById(@PathVariable("id") long id) {
        DeviceDTO device = deviceService.findById(id);
        if(device != null) {
            return APIResponse.createSuccessResponse(device);
        }
        return APIResponse.createErrorResponse("No device found with the given id");
    }

    @PutMapping()
    public JsonNode updateById(@RequestBody() DeviceDTO device) {
        DeviceDTO updatedDevice = deviceService.updateDeviceById(device);
        if(updatedDevice != null) {
            return APIResponse.createSuccessResponse(device);
        }
        return APIResponse.createErrorResponse("No device found with the given id");
    }

    @DeleteMapping("/{id}")
    public JsonNode delete(@PathVariable("id") long id) {
        boolean deleted = deviceService.deleteDeviceById(id);
        if(deleted) {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode result = mapper.createObjectNode();
            result.put("message:", "Device deleted successfully");
            return APIResponse.createSuccessResponse(result);
        }
        return APIResponse.createErrorResponse("No device found with the give id");
    }

    @PostMapping()
    public JsonNode create(@RequestBody() DeviceDTO device) {
        boolean created = deviceService.createDevice(device);
        if(created) {
            return APIResponse.createSuccessResponse(device);
        }
        return APIResponse.createErrorResponse("Error while trying to save device");
    }
}

package com.entgra.task1.restdeviceapi.service;

import com.entgra.task1.restdeviceapi.dao.DeviceDAO;
import com.entgra.task1.restdeviceapi.dao.IDeviceDAO;
import com.entgra.task1.restdeviceapi.models.Device;
import com.entgra.task1.restdeviceapi.models.dto.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService implements IDeviceService {
    @Autowired
    IDeviceDAO deviceDAO;

    @Override
    public List<DeviceDTO> findAll() {
        return deviceListToDeviceDTOList(deviceDAO.findAll());
    }

    @Override
    public DeviceDTO findById(long id) {
        Device device = deviceDAO.findById(id).orElse(null);
        if(device != null) {
            return deviceToDeviceDTO(device);
        }
        return null;
    }

    @Override
    public boolean createDevice(DeviceDTO device) {
        return deviceDAO.save(deviceDTOToDevice(device));
    }

    @Override
    public boolean deleteDeviceById(long id) {
        return deviceDAO.deleteById(id);
    }

    @Override
    public DeviceDTO updateDeviceById(DeviceDTO deviceDTO) {
        Device device = deviceDTOToDevice(deviceDTO);
        Device updatedDevice = deviceDAO.updateById(device).orElse(null);
        if(updatedDevice != null) {
            return deviceToDeviceDTO(updatedDevice);
        }
        return null;
    }

    // helpers
    private static DeviceDTO deviceToDeviceDTO(Device device) {
        long id = device.getId();
        String name = device.getName();
        String model = device.getModel();
        Device.status status = device.getStatus();
        return new DeviceDTO(id, name, model, status);
    }
    private static Device deviceDTOToDevice(DeviceDTO deviceDTO) {
        long id = deviceDTO.getId();
        String name = deviceDTO.getName();
        String model = deviceDTO.getModel();
        Device.status status = deviceDTO.getStatus();
        return new Device(id, name, model, status);
    }
    private static List<DeviceDTO> deviceListToDeviceDTOList(List<Device> device) {
        List<DeviceDTO> deviceDTOList = device.stream().map(DeviceService::deviceToDeviceDTO).collect(Collectors.toList());
        return deviceDTOList;
    }
    private static List<Device> deviceDTOListToDeviceList(List<DeviceDTO> deviceDTO) {
        List<Device> deviceList = deviceDTO.stream().map(DeviceService::deviceDTOToDevice).collect(Collectors.toList());
        return deviceList;
    }
}

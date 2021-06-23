package com.entgra.task1.restdeviceapi.service;

import com.entgra.task1.restdeviceapi.models.Device;
import com.entgra.task1.restdeviceapi.models.dto.DeviceDTO;

import java.util.List;
import java.util.Optional;

public interface IDeviceService {
   List<DeviceDTO> findAll();
   DeviceDTO findById(long Id);
   boolean createDevice(DeviceDTO device);
   boolean deleteDeviceById(long id);
   DeviceDTO updateDeviceById(DeviceDTO deviceDTO);
}

package com.entgra.task1.restdeviceapi.dao;

import com.entgra.task1.restdeviceapi.db.Database;
import com.entgra.task1.restdeviceapi.models.Device;
import com.entgra.task1.restdeviceapi.models.dto.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Date;

@Component
public class DeviceDAO implements IDeviceDAO {
    @Autowired
    Database db;
    @Override
    public List<Device> findAll() {
        Connection connection = db.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM device");
            List<Device> devices = new ArrayList<>();

            while(rs.next())
            {
                Device device = extractDeviceResultsSet(rs);
                devices.add(device);
            }

            return devices;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Device> findById(long id) {
        Connection connection = db.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM device WHERE id=" + id);

            if(rs.next())
            {
                return Optional.ofNullable(extractDeviceResultsSet(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.ofNullable(null);
    }

    @Override
    public boolean save(Device device) {
        Connection connection = db.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO device(name, model, status, enrolledTime) VALUES (?, ?, ?, ?)");
            ps.setString(1, device.getName());
            ps.setString(2, device.getModel());
            String status = device.getStatus().name();
            ps.setString(3, status);
            ps.setTimestamp(4, getCurrentTimeStamp());
            int i = ps.executeUpdate();

            if(i == 1) {
                return i == i;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        Connection connection = db.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM device WHERE id=" + id);
            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Optional<Device> updateById(Device device) {
        Connection connection = db.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE device SET name=?, model=?, status=? WHERE id=?");
            ps.setString(1, device.getName());
            ps.setString(2, device.getModel());
            String status = device.getStatus().name();
            ps.setString(3, status);
            ps.setLong(4, device.getId());
            int i = ps.executeUpdate();

            if(i == 1) {
                return Optional.ofNullable(device);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.ofNullable(null);
    }

    // helper
    private static Device extractDeviceResultsSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String model = rs.getString("model");
        String statusStr = rs.getString("status");
        Device.status status = Device.status.valueOf(statusStr);
        Date enrolledTime = rs.getObject(5, Date.class);
        return new Device(id, name, model, status, enrolledTime);
    }
    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
}

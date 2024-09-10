package com.truck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverService {

    //adding Driver
    public void addDriver(Driver d1) throws SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "insert into drivers(driverId,driverName,licenceNo,mobileNo)values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,d1.getDriverId());
        preparedStatement.setString(2,d1.getDriverName());
        preparedStatement.setString(3,d1.getLicenceNo());
        preparedStatement.setString(4,d1.getMobileNo());
        int i = preparedStatement.executeUpdate();
    }
    //Show Drivers
    public List<Driver> getAllDriver() throws SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "select * from drivers";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Driver> drivers = new ArrayList<>();
        while(resultSet.next()){
            Driver d1=new Driver();
            d1.setDriverId(resultSet.getInt(1));
            d1.setDriverName(resultSet.getString(2));
            d1.setLicenceNo(resultSet.getString(3));
            d1.setMobileNo(resultSet.getString(4));
            drivers.add(d1);
        }
        return drivers;
    }
}

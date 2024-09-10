package com.truck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TruckService {
    //add truck method
    public void addTruck(Truck truck) throws SQLException {
        Connection connection = DbConnection.getConnection();
    String sql ="insert into trucks (truckID,truckName,truckNumber,capacity) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,truck.getTruckId());
        preparedStatement.setString(2,truck.getTruckName());
        preparedStatement.setString(3,truck.getTruckNumber());
        preparedStatement.setString(4,truck.getCapacity());
        int i = preparedStatement.executeUpdate();
    }
    //Show trucks
    public List<Truck> getAllTruck() throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        String sql = "select * from trucks";
        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Truck t1 = new Truck();
            t1.setTruckId(resultSet.getInt(1));
            t1.setTruckName(resultSet.getString(2));
            t1.setTruckNumber(resultSet.getString(3));
            t1.setCapacity(resultSet.getString(4));
            trucks.add(t1);
        }
        return trucks;
    }
}

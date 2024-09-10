package com.truck;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripService {
    //adding Trip here
    public void addTrip(Trip tri,Truck truck,Driver driver){
        String sql = "insert into trip(tripId,truckID,driverID,startLocation,endLocation,distance)values(?,?,?,?,?,?)";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,tri.getTripId());
            preparedStatement.setInt(2,truck.getTruckId());
            preparedStatement.setInt(3,driver.getDriverId());
            preparedStatement.setString(4,tri.getStartingLocation());
            preparedStatement.setString(5,tri.getEndingLocation());
            preparedStatement.setInt(6,tri.getDistance());
            int i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Show all Trips
    public List<Trip> getAllTrips(){
        String sql = "select * from trip";
        List<Trip> trips = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Trip trip = new Trip();
                trip.setTripId(resultSet.getInt(1));
                trip.setStartingLocation(resultSet.getString(4));
                trip.setEndingLocation(resultSet.getString(5));
                trip.setDistance(resultSet.getInt(6));
                trips.add(trip);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trips;
    }

    //Get Trips
    public List<TripDetails> getTrips(){
        List<TripDetails> tripList = new ArrayList<>();
        String sql = "SELECT\n" +
                "    trip.tripId,\n" +
                "    trip.startLocation,\n" +
                "    trip.endLocation,\n" +
                "    trip.distance,\n" +
                "    trucks.truckName,\n" +
                "    trucks.truckNumber,\n" +
                "    drivers.driverName,\n" +
                "    drivers.mobileNo\n" +
                "FROM\n" +
                "    trip\n" +
                "INNER JOIN\n" +
                "    trucks ON trip.truckId = trucks.truckId\n" +
                "INNER JOIN\n" +
                "    drivers ON trip.driverId = drivers.driverId";

        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()){
               TripDetails tripDetails = new TripDetails();
                tripDetails.setTripId(resultSet.getInt(1));
                tripDetails.setStartingLocation(resultSet.getString(2));
                tripDetails.setEndingLocation(resultSet.getString(3));
                tripDetails.setDistance(resultSet.getInt(4));
                tripDetails.setTruckName(resultSet.getString(5));
                tripDetails.setTruckNumber(resultSet.getString(6));
                tripDetails.setDriverName(resultSet.getString(7));
                tripDetails.setMobileNo(resultSet.getString(8));
                tripList.add(tripDetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tripList;
    }
}

package com.truck;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        Truck truck =new Truck(102,"TATA","UP-60-2024","1200");
        Truck truck2 =new Truck(103,"MHENDRA","UP-60-2022","1500");

        Driver driver = new Driver(112,"Nikhil","N0123","258964");
        Driver driver2 = new Driver(113,"Vishal","V0125","85469");

        Trip trip = new Trip(1002,truck,driver,"Delhi","Mau",1200);
        Trip trip2 = new Trip(1003,truck2,driver2,"Lucknow","Kanpur",900);

        TruckService truckService = new TruckService();
        DriverService driverService = new DriverService();
        TripService tripService = new TripService();

        //Adding Truck
       // truckService.addTruck(truck);
       // truckService.addTruck(truck2);
        //Adding Driver
       // driverService.addDriver(driver2);
       // driverService.addDriver(driver);
        //Adding Trip
       // tripService.addTrip(trip,truck,driver);
      //  tripService.addTrip(trip2,truck2,driver2);

        List<Truck> allTruck = truckService.getAllTruck();
        for(Truck t1: allTruck){
        System.out.println(t1);
        }
        List<Driver> allDriver = driverService.getAllDriver();
        for(Driver d1: allDriver){
            System.out.println(d1);
        }

        //print all trips
        List<TripDetails> allTrips = tripService.getTrips();
        for(TripDetails tr1: allTrips){
            System.out.println(tr1);
        }

    }
}

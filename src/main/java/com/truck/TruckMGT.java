package com.truck;

import java.sql.SQLException;
import java.util.Scanner;

public class TruckMGT {
    static{
        System.out.println("=========================================================================");
        System.out.println("\t\t\t\t\t\t Truck Management System");
        System.out.println("=========================================================================");
    }
    private static final String userName="admin@123";
    private static final String userPassword="admin123";


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        TruckService truckService = new TruckService();
        DriverService driverService = new DriverService();

        //Menu Draven Program
        while(true){
            System.out.println();
            System.out.println("=====================ADMIN LOGIN=======================");
            System.out.print("\t\t Enter Admin Username:: ");
            String uName = sc.next();
            System.out.print("\t\t Enter Admin Password:: ");
            String uPass = sc.next();
            System.out.println();
            if (userName.equals(uName)&&userPassword.equals(uPass)){
                while(true){
                    menu_Display();
                    System.out.print(" \tEnter your Choice:: ");
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("=====================Adding Truck's=======================");
                            System.out.print(" \t Enter Truck Id:: ");
                            int truckId=sc.nextInt();
                            System.out.print(" \t Enter Truck Name:: ");
                            String truckName=sc.next();
                            System.out.print(" \t Enter Truck Capacity:: ");
                            String capacity=sc.next();
                            System.out.print(" \t Enter Truck Number:: ");
                            String truckNumber=sc.next();
                            Truck truck = new Truck(truckId,truckName,truckNumber,capacity);
                            truckService.addTruck(truck);
                            break;
                        case 2:
                            System.out.println("=====================Adding Driver's=======================");
                            System.out.print(" \t Enter Driver Id:: ");
                            int driverId =sc.nextInt();
                            System.out.print(" \t Enter driverName:: ");
                            String driverName=sc.next();
                            System.out.print(" \t Enter licenceNo Id:: ");
                            String licenceNo=sc.next();
                            System.out.print(" \t Enter mobile Id:: ");
                            String mobileNo=sc.next();
                            Driver driver = new Driver(driverId,driverName,licenceNo,mobileNo);
                            driverService.addDriver(driver);
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            return;
                        default:
                            break;
                    }
                }
            }
        }
    }
    //Manu-Display method here
    public static void menu_Display(){
        System.out.println();
        System.out.println("====================== WELCOME ========================");
        System.out.println(" \t1.Add Truck's. "+"\t\t"+"2.Add Driver's.");
        System.out.println(" \t3.Show Truck's. "+"\t"+"4.Show Driver's.");
        System.out.println(" \t5.Add Trip's. "+"\t\t"+"6.Show Trip's Details.");
        System.out.println(" \t\t\t7.Admin Logout");
    }
}

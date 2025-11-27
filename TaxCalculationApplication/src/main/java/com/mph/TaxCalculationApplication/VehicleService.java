package com.mph.TaxCalculationApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleService {
	ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Scanner sc) {
        System.out.print("Enter registration number: ");
        String reg = sc.next();

        System.out.print("Enter brand: ");
        String brand = sc.next();

        System.out.print("Enter max velocity: ");
        int vel = sc.nextInt();

        System.out.print("Enter no. of seats: ");
        int seats = sc.nextInt();

        System.out.print("Enter vehicle type (1-Petrol, 2-Diesel, 3-CNG): ");
        int type = sc.nextInt();

        System.out.print("Enter purchase cost: ");
        double cost = sc.nextDouble();

        Vehicle v = new Vehicle(reg, brand, vel, seats, type, cost);
        vehicles.add(v);

        System.out.println("Vehicle added successfully!");
    }

    public void calculateVehicleTax() {
        for (Vehicle v : vehicles) {
            v.calculateTax();
        }
        System.out.println("Vehicle tax calculated!");
    }

    public void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicle data found.");
            return;
        }

        System.out.println("REGNO      BRAND     VELOCITY   SEATS     TYPE       PURCHASE      TAX");
        System.out.println("--------------------------------------------------------------------");

        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public double getTotalVehicleTax() {
        return vehicles.stream().mapToDouble(Vehicle::getVehicleTax).sum();
    }

    // ⭐ MISSING METHOD (required by Main)
    public int getTotalVehicles() {
        return vehicles.size();
    }

}

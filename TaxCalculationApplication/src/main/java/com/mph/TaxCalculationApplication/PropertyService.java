package com.mph.TaxCalculationApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class PropertyService {
	private ArrayList<Property> properties = new ArrayList<>();
    private int idCounter = 1;

    public void addProperty(Scanner sc) {
        System.out.print("Enter base value of land: ");
        double base = sc.nextDouble();

        System.out.print("Enter built-up area: ");
        double area = sc.nextDouble();

        System.out.print("Enter age of property: ");
        int age = sc.nextInt();

        System.out.print("Is the property in city? (Y/N): ");
        char city = sc.next().charAt(0);

        Property p = new Property(idCounter++, base, area, age, city);
        properties.add(p);

        System.out.println("Property added successfully!");
    }

    public void calculatePropertyTax() {
        for (Property p : properties) {
            p.calculateTax();
        }
        System.out.println("Property tax calculated!");
    }

    public void displayProperties() {
        if (properties.isEmpty()) {
            System.out.println("No property data found.");
            return;
        }

        System.out.println("ID   AREA      BASEVALUE    AGE     CITY     TAX");
        System.out.println("--------------------------------------------------------------");

        for (Property p : properties) {
            System.out.println(p);
        }
    }

   
    public int getTotalProperties() {
        return properties.size();   // your ArrayList name must be 'properties'
    }

    public double getTotalPropertyTax() {
        double total = 0;
        for (Property p : properties) {
            total += p.getPropertyTax();   // use your getter method name
        }
        return total;
    }
    
}

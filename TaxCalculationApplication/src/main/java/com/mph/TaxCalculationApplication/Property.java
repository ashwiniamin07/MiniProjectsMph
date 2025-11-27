package com.mph.TaxCalculationApplication;

public class Property implements TaxCalculator {
	private int id;
    private double baseValue;
    private double builtUpArea;
    private int age;
    private char inCity; // Y or N
    private double propertyTax;

    public Property(int id, double baseValue, double builtUpArea, int age, char inCity) {
        this.id = id;
        this.baseValue = baseValue;
        this.builtUpArea = builtUpArea;
        this.age = age;
        this.inCity = Character.toUpperCase(inCity);
    }

    @Override
    public double calculateTax() {
        double ageFactor = age * 0.02; // Example factor
        if (inCity == 'Y') {
            propertyTax = (builtUpArea * ageFactor * baseValue) + (0.05 * builtUpArea);
        } else {
            propertyTax = builtUpArea * ageFactor * baseValue;
        }
        return propertyTax;
    }

    public int getId() { return id; }
    public double getPropertyTax() { return propertyTax; }

    @Override
    public String toString() {
        return String.format("%-5d %-10.2f %-10.2f %-10d %-5s %-10.2f",
                id, builtUpArea, baseValue, age, inCity, propertyTax);
    }

}

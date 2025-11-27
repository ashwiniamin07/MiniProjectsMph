package com.mph.TaxCalculationApplication;

public class Vehicle implements TaxCalculator {
	 private String regNo;
	    private String brand;
	    private int maxVelocity;
	    private int seats;
	    private int type; // 1 - petrol, 2 - diesel, 3 - CNG
	    private double purchaseCost;
	    private double vehicleTax;
	    
	    public Vehicle(String regNo, String brand, int maxVelocity, int seats, int type, double purchaseCost) {
	        this.regNo = regNo;
	        this.brand = brand;
	        this.maxVelocity = maxVelocity;
	        this.seats = seats;
	        this.type = type;
	        this.purchaseCost = purchaseCost;
	    }


	@Override
	public double calculateTax() {
		 switch (type) {
         case 1: vehicleTax = maxVelocity + seats + (0.10 * purchaseCost); break;
         case 2: vehicleTax = maxVelocity + seats + (0.11 * purchaseCost); break;
         case 3: vehicleTax = maxVelocity + seats + (0.12 * purchaseCost); break;
     }
     return vehicleTax;
	}
	public String getRegNo() { return regNo; }
    public double getVehicleTax() { return vehicleTax; }
    

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10d %-10d %-10d %-12.2f %-10.2f",
                regNo, brand, maxVelocity, seats, type, purchaseCost, vehicleTax);
    }

}

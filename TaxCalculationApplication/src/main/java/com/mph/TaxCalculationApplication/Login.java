package com.mph.TaxCalculationApplication;

import java.util.Scanner;

public class Login {
	public boolean doLogin(Scanner sc) {
        System.out.print("USERNAME : ");
        String u = sc.next();

        System.out.print("PASSWORD : ");
        String p = sc.next();

        return u.equals("admin") && p.equals("admin123");
    }
}

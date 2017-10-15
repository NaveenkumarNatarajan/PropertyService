package com.pilot.validation;

import java.util.Scanner;

import com.pilot.util.Commons;

public class PropRentalPriceValidator {

	private static Scanner scanner = new Scanner(System.in);
	
	public static String validate(String rentalValue) {
		while(true){
			if(rentalValue.trim().length() == 0){
				Commons.printMessage("Validation Failed! This field is Mandatory");
				Commons.print(" Please enter Rental Price: ");
				rentalValue = scanner.nextLine();
			}else if(rentalValue.matches("[a-z]+")){
				Commons.printMessage("Validation Failed! Invalid Values provided. Only Numbers are allowed.");
				Commons.print(" Please enter Rental Price: ");
				rentalValue = scanner.nextLine();
			}else
				break;
		}
		return rentalValue;
	}
}

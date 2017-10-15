package com.pilot.validation;

import java.util.Scanner;

import com.pilot.util.Commons;

public class PropCurrentValueValidator {

private static Scanner scanner = new Scanner(System.in);
	
	public static String validate(String currentValue) {
		while(true){
			if(currentValue.trim().length() == 0){
				Commons.printMessage("Validation Failed! This field is Mandatory");
				Commons.print(" Please enter Current Value: ");
				currentValue = scanner.nextLine();
			}else if(currentValue.matches("[a-z]+")){
				Commons.printMessage("Validation Failed! InValid Values provided. Only Numbers are allowed");
				Commons.print(" Please enter Current Value: ");
				currentValue = scanner.nextLine();
			}else
				break;
		}
		return currentValue;
	}
}

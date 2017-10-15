package com.pilot.validation;

import java.util.Scanner;

import com.pilot.util.Commons;

public class PropAreaValidator {
	private static Scanner scanner = new Scanner(System.in);
	
	public static String validate(String propertyArea) {
		while(true){
			if(propertyArea.trim().length() == 0){
				Commons.printMessage("Validation Failed! This field is Mandatory");
				Commons.print(" Please enter Property Area: ");
				propertyArea = scanner.nextLine();
			}else if(propertyArea.length() > 45){
				Commons.printMessage("Validation Failed! Property Area should not contain more than 45 characters");
				Commons.print(" Please enter property Area: ");
				propertyArea= scanner.nextLine();
			}else
				break;
		}
		return propertyArea;
	}
}

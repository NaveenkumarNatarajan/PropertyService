package com.pilot.validation;

import java.util.Scanner;

import com.pilot.util.Commons;

public class PropManagerNameValidator {

	private static Scanner scanner = new Scanner(System.in);
	
	public static String validate(String propertyManagerName) {
		while(true){
			if(propertyManagerName.trim().length() == 0){
				Commons.printMessage("Validation Failed! This field is Mandatory");
				Commons.print(" Please enter Property Manager Name: ");
				propertyManagerName = scanner.nextLine();
			}else if(propertyManagerName.length() > 45){
				Commons.printMessage("Validation Failed! Property Manager Name should not contain more than 45 characters.");
				Commons.print(" Please enter Property Manager Name: ");
				propertyManagerName = scanner.nextLine();
			}else if(propertyManagerName.matches("[0-9]+")){
				Commons.printMessage("Validation Failed! Numbers are not allowed in Name.");
				Commons.print(" Please enter Property Manager Name: ");
				propertyManagerName = scanner.nextLine();
			}else
				break;
		}
		return propertyManagerName;
	}
}

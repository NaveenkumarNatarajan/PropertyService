package com.pilot.validation;

import java.util.Scanner;

import com.pilot.util.Commons;

public class PropNameValidator{

	private static Scanner scanner = new Scanner(System.in);
	
	public static String validate(String propertyName) {
		while(true){
			if(propertyName.trim().length() == 0){
				Commons.printMessage("Validation Failed! This field is Mandatory");
				Commons.print(" Please enter Property Name: ");
				propertyName = scanner.nextLine();
			}else if(propertyName.length() > 45){
				Commons.printMessage("Validation Failed!Property name should not contain more than 45 characters");
				Commons.print(" Please enter property name: ");
				propertyName = scanner.nextLine();
			}else
				break;
		}
		return propertyName;
	}
}

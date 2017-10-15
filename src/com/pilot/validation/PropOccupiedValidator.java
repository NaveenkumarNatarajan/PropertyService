package com.pilot.validation;

import java.util.Scanner;

import com.pilot.util.Commons;

public class PropOccupiedValidator {
	private static Scanner scanner = new Scanner(System.in);
	public static String validate(String occupied) {
		while(true){
			if(occupied.trim().length() == 0){
				Commons.printMessage("Validation Failed! This field is Mandatory");
				Commons.print(" Please enter Occupied: ");
				occupied = scanner.nextLine();
			}else if(!occupied.equalsIgnoreCase("false") && !occupied.equalsIgnoreCase("true")){
				Commons.printMessage("Validation Failed! InValid Values provided. Only True or False allowed.");
				Commons.print(" Please enter Occupied: ");
				occupied = scanner.nextLine();
			}else
				break;
		}
		return occupied;

	}
}

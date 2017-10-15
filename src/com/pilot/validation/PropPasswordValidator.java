package com.pilot.validation;

import java.util.Scanner;

import com.pilot.util.Commons;

public class PropPasswordValidator {
private static Scanner scanner = new Scanner(System.in);
	
	public static String validate(String password) {
		while(true){
			if(password.trim().length() == 0){
				Commons.printMessage("Validation Failed! This field is Mandatory");
				Commons.print(" Please enter Password: ");
				password = scanner.nextLine();
			}else if(password.length() > 8){
				Commons.printMessage("Validation Failed! Password should not contain more than 8 characters");
				Commons.print(" Please enter password: ");
				password = scanner.nextLine();
			}else
				break;
		}
		return password;
	}
}

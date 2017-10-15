package com.pilot.main;

import java.util.Scanner;
import com.pilot.core.RequestHandler;
import com.pilot.util.Commons;

public class Main {

	private static Scanner consoleInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		Commons.displayOption();
	        while (true) {
	        	Commons.print(" Please enter option: ");
	            String input = consoleInput.nextLine();
	            
	            if (!input.matches("[0-8]")) {
	            	Commons.printMessage(" ----> Invalid Option !");
	            }else{
	            	int option = Integer.parseInt(input);
		        	switch(option){
		        		case 0 :Commons.displayOption();break;
		        		case 1 :RequestHandler.addNewProperty();break;
		        		case 2 :RequestHandler.doUpdateProperty();break;
		        		case 3 :RequestHandler.showAllProperties();break;
		        		case 4 :RequestHandler.showAllPropertiesbyArea();break;
		        		case 5 :RequestHandler.showAllPropertiesOccupied();break;
		        		case 6 :RequestHandler.showAllManagerCommission();break;
		        		case 7 :RequestHandler.doRegisterPropertyManager();break;
		        		case 8 :Commons.print(" Thank you!");System.exit(0);
		        	}
	        }
		}
	}
}
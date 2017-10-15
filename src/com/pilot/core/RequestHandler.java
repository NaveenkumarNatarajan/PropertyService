package com.pilot.core;

import java.util.Scanner;

import com.pilot.util.Commons;
import com.pilot.util.PropertyUtil;
import com.pilot.validation.PropAreaValidator;
import com.pilot.validation.PropCurrentValueValidator;
import com.pilot.validation.PropManagerNameValidator;
import com.pilot.validation.PropNameValidator;
import com.pilot.validation.PropOccupiedValidator;
import com.pilot.validation.PropPasswordValidator;
import com.pilot.validation.PropRentalPriceValidator;

/**
 * <h1>A Request Handler class contains methods that serves User's Request using ProperyUtil class</h1> 
 * @author Naveen
 * @since 2017-08-11
 * @version 1.0
 *
 */
public class RequestHandler {

	private static String propertyName = "", area = "", rentalPrice = "", currentValue = "";
	private static String occupied = "", propertyManager = "", propertybyArea = "";
	private static Scanner scanner = new Scanner(System.in);
	
	public static void addNewProperty(){	//Add new Property
    	Commons.print(" Please enter Property Name: ");	propertyName = scanner.nextLine();
    	propertyName = PropNameValidator.validate(propertyName);
        Commons.print(" Please enter Area: ");	area = scanner.nextLine();
        area=PropAreaValidator.validate(area);
        Commons.print(" Please enter Rental Price: ");	rentalPrice = scanner.nextLine();
        rentalPrice = PropRentalPriceValidator.validate(rentalPrice);
        Commons.print(" Please enter Current value: ");	currentValue = scanner.nextLine();
        currentValue = PropCurrentValueValidator.validate(currentValue);
        Commons.print(" Please enter Occupied: ");	occupied = scanner.nextLine();
        occupied = PropOccupiedValidator.validate(occupied);
        Commons.print(" Please enter Property Manager Name: ");	propertyManager = scanner.nextLine();
        propertyManager = PropManagerNameValidator.validate(propertyManager);
        Commons.printMessage(PropertyUtil.addProperty(propertyName, area, rentalPrice, currentValue, occupied, propertyManager,false));
        Commons.printLineSeparator();
    }
	public static void doUpdateProperty(){

		Commons.print(" Please enter property Manager Name: ");	
		propertyManager = scanner.nextLine();propertyManager = PropManagerNameValidator.validate(propertyManager);
		Commons.print(" Please enter password: ");	
		String password = scanner.nextLine();
		boolean isValidUser = User.authenticateUser(propertyManager, password);
		if(!isValidUser ){
			Commons.printMessage(" ----> Incorrect Credential Used or you are not registered yet!");
			return;
		}
		else if (!PropertyUtil.isPropertyAvailablebyPropertyManager(propertyManager)){
			Commons.printMessage(" ----> No property found to Edit, please add one.");
			return;
		}else
			PropertyUtil.getAllPropertybyPropertyManager(propertyManager);
			Commons.print(" Please enter property Name that you want to update: ");	
			propertyName = scanner.nextLine();	
			propertyName = PropNameValidator.validate(propertyName);
			PropertyUtil.getPropertybyPropertyName(propertyName);
	        Commons.print(" Please enter Area: ");	area = scanner.nextLine();	
	        area=PropAreaValidator.validate(area);
	        Commons.print(" Please enter Rental Price: ");	rentalPrice = scanner.nextLine();	
	        rentalPrice = PropRentalPriceValidator.validate(rentalPrice);
	        Commons.print(" Please enter Current value: ");	currentValue = scanner.nextLine();	
	        currentValue = PropCurrentValueValidator.validate(currentValue);
	        Commons.print(" Please enter occupied: ");	occupied = scanner.nextLine();	
	        occupied = PropOccupiedValidator.validate(occupied);
	        boolean EditModeFlag = true;
	        Commons.printMessage(PropertyUtil.addProperty(propertyName, area, rentalPrice, currentValue, occupied, propertyManager,EditModeFlag));
	}
	
	public static void doRegisterPropertyManager(){
		
		Commons.print(" Please enter property Manager Name: ");	
		propertyManager = scanner.nextLine();	propertyName = PropNameValidator.validate(propertyName);
		Commons.print(" Please enter password: ");	
		String password = scanner.nextLine();password = PropPasswordValidator.validate(password);
		User user = new User();
		user.setManagerName(propertyManager);
		user.setPassword(password);
		User.registerUser(user);
		Commons.printMessage(" ----> Registered successfully!");
	}
	
	public static void showAllProperties(){	//List All Properties
        if(PropertyUtil.isPropertyAvailable()){
        	Commons.printLineSeparator();
        	Commons.printMessage("Printing All Properties: ");
        	Commons.printHeaders();
        	PropertyUtil.getAllProps();
        	Commons.printLineSeparator();
        }else
        	Commons.printNoPropertyAvailable();
	}
	
	public static void showAllPropertiesbyArea(){	//Take Property Area and list properties available in the area
		if(PropertyUtil.isPropertyAvailable()){
			Commons.printLineSeparator();
			Commons.printMessage("Please enter property Area: ");
	        propertybyArea = scanner.nextLine();
	        PropertyUtil.getPropertybyArea(propertybyArea);
	        Commons.printLineSeparator();
		}else
			Commons.printNoPropertyAvailable();
	}

	public static void showAllPropertiesOccupied(){ //List all property that are occupied
		if(PropertyUtil.isPropertyAvailable()){
			Commons.printLineSeparator();
			PropertyUtil.getAllPropertyOccupied();
		}else
			Commons.printNoPropertyAvailable();
	}
	
	public static void showAllManagerCommission(){ 	//Take property manager's name, calculate and print commission
		if(PropertyUtil.isPropertyAvailable()){
			Commons.printLineSeparator();
			Commons.printMessage(" Please enter Property Manager Name to know commission: ");
			propertyManager = scanner.nextLine();
	        Commons.printMessage(" Commision for `"+ propertyManager +"`- "+ 
	        						PropertyUtil.getPropManagerCommission(propertyManager));
		}else
			Commons.printNoPropertyAvailable();
	}
}
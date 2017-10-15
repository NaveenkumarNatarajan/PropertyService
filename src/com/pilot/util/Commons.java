package com.pilot.util;

/**
 * <h1>A Commons class with generic and common methods created for better reusablity.</h1> 
 * @author Naveen
 * @since 2017-08-11
 * @version 1.0
 *
 */
public class Commons {

	public static void printHeaders(){
		StringBuffer header = new StringBuffer();
		header.append("Property Name");
		header.append(", Area");
		header.append(", current Value");
		header.append(", Occupied");
		header.append(", Property Manager");
		header.append(", Rental Price \n");
		printMessage(header.toString());
	}
	
	public static void printLineSeparator(){
		System.out.println("-----------");
	}
	
	public static void printMessage(String message){
		System.out.println(message);
	}
	public static void print(String message){
		System.out.print(message);
	}	
	public static void printNoPropertyAvailable(){
		printMessage(" ----> There is no property, please add one to view ! \n");
	}
	
	public static void displayOption(){
		Commons.printLineSeparator();
		Commons.print(" To see Option Again: 0\n");
    	Commons.print(" To Add New Property: 1\n");
    	Commons.print(" To Update a Property: 2\n");
    	Commons.print(" To view All Property: 3\n");
    	Commons.print(" To view property by Area: 4\n");
    	Commons.print(" To view all property that are occupied: 5\n");
    	Commons.print(" To view Manager's Commission: 6\n");
    	Commons.print(" To Register as Property Manager: 7\n");
    	Commons.print(" To Exit: 8\n");
    	Commons.printLineSeparator();
	}
}
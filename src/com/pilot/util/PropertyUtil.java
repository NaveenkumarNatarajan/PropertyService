package com.pilot.util;

import java.util.ArrayList;

import com.pilot.core.Property;
import com.pilot.core.User;
import com.pilot.util.Commons;
/**
 * <h1>A PropertyUtil class contains all utily methods to serve Request handler</h1> 
 * @author Naveen
 * @since 2017-08-11
 * @version 1.0
 *
 */
public class PropertyUtil extends Property{

	private static ArrayList<Property> allProps =  new ArrayList<Property>();
	
	private final static double MANAGER_COMMISSION_PERCENT =  0.1;
	
	public static String addProperty(String propertyName, String area, String rentalPrice, 
			String currentValue, String occupied, String propertyManager, boolean EditModeFlag){
		Property prop = new Property();
		prop.setPropertyName(propertyName);
		prop.setArea(area);
		prop.setCurrentValue(currentValue);
		prop.setOccupied(occupied);
		prop.setRentalPrice(rentalPrice);
		prop.setPropertyManager(propertyManager);
			int removeIndex = -1;
			for(int pos=0 ; pos<allProps.size();pos++){
				if(allProps.get(pos).getPropertyName().equalsIgnoreCase(propertyName) && 
				   allProps.get(pos).getPropertyManager().equalsIgnoreCase(propertyManager)&&
				   allProps.get(pos).getArea().equalsIgnoreCase(area)){
					removeIndex = pos;
					break;
				}
			}
			if(EditModeFlag && removeIndex > -1){
				allProps.remove(removeIndex);
				allProps.add(prop);
				return " ----> Updated Successfully";
			}
			else if(!EditModeFlag && removeIndex > -1){
				return " ----> Property Already Exist, please choose option Edit to update if required !";
			}else
				allProps.add(prop);
				
		return " ----> Added Successfully";
	}
	
	public static void getPropertybyArea(String area){
		if(isPropertyAvailableInArea(area)){ 
			Commons.printMessage(" Printing properties in Area: " +area);
			Commons.printLineSeparator();
			Commons.printHeaders();
			for(Property prop : allProps){
				if(prop.getArea().equalsIgnoreCase(area))
					Commons.printMessage(prop.toString());
			}
		}else
			Commons.printMessage(" ----> There is no property found in area: "+ area);
	}
	
	public static boolean isPropertyAvailableInArea(String area){
		boolean availability = false;
		for(Property prop : allProps){
			if(prop.getArea().equalsIgnoreCase(area)){
				availability = true;
				break;
			}
		}
		return availability;
	}
	
	public static boolean isPropertyAvailablebyPropertyManager(String propertyManager){
		boolean availability = false;
		for(Property prop : allProps){
			if(prop.getPropertyManager().equalsIgnoreCase(propertyManager)){
				availability = true;
				break;
			}
		}
		return availability;
	}
	
	public static boolean isPropertyAvailablebyPropertyName(String propertyName){
		boolean availability = false;
		for(Property prop : allProps){
			if(prop.getPropertyName().equalsIgnoreCase(propertyName)){
				availability = true;
				break;
			}
		}
		return availability;
	}
	
	public static boolean isPropertyAvailable(){
		return allProps.size() > 0 ? true : false;
	}
	
	public static void getAllProps(){
		for(Property prop : allProps){
			Commons.printMessage(prop.toString());
		}
	}
	
	public static void getAllPropertyOccupied(){
		int occupied = 0; 
		for(Property prop : allProps){
			if(prop.getOccupied().equalsIgnoreCase("true")){
				Commons.printMessage(prop.toString());
				occupied ++;
			}
		}
		if(occupied == 0)
			Commons.printMessage(" ----> There is no property occupied");
	}

	public static String getPropManagerCommission(String propManagerName){
		long commission = 0;
		for(Property prop : allProps){
			if(prop.getPropertyManager().equalsIgnoreCase(propManagerName))
				commission += (long) ( Long.parseLong(prop.getRentalPrice()) * MANAGER_COMMISSION_PERCENT );
		}
		return commission + "";
	}
	
	
	public static void getAllPropertybyPropertyManager(String propertyManager){
		
		if(isPropertyAvailablebyPropertyManager(propertyManager)){ 
			Commons.printMessage("Here are the List of Property you Manage");
			Commons.printLineSeparator();
			Commons.printHeaders();
			for(Property prop : allProps){
				if(prop.getPropertyManager().equalsIgnoreCase(propertyManager))
					Commons.printMessage(prop.toString());
			}
		}else
			Commons.printNoPropertyAvailable();
	}
	
	public  static void getPropertybyPropertyName(String propertyName){
		if(isPropertyAvailablebyPropertyName(propertyName)){ 
			Commons.printMessage("Here is the property detail you want to edit");
			Commons.printLineSeparator();
			Commons.printHeaders();
			for(Property prop : allProps){
				if(prop.getPropertyName().equalsIgnoreCase(propertyName))
					Commons.printMessage(prop.toString());
			}
		}else
			Commons.printMessage("No Property Available by Name: "+propertyName);
	}
}
package com.pilot.core;

public class Property {

	private String area;
	private String rentalPrice;
	private String currentValue;
	private String occupied;
	private String propertyManager;
	
	private String propertyName;
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(String rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public String getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	public String getOccupied() {
		return occupied;
	}
	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}
	public String getPropertyManager() {
		return propertyManager;
	}
	public void setPropertyManager(String propertyManager) {
		this.propertyManager = propertyManager;
	}
	
	public String toString(){
		StringBuffer prop = new StringBuffer();
		prop.append(this.propertyName);
		prop.append(", " + this.area);
		prop.append(", " + this.currentValue);
		prop.append(", " + this.occupied);
		prop.append(", " + this.propertyManager);
		prop.append(", " + this.rentalPrice);
		return prop.toString();
	}
}

package com.pilot.core;

import java.util.ArrayList;

public class User {

	private String managerName;
	private String password;
	private static ArrayList<User> userList =  new ArrayList<User>();
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void registerUser(User user){
		userList.add(user);
	}
	
	public static boolean authenticateUser(String name, String password){
		boolean isUserAvailable = false;
		for(User user: userList){
			if(user.getManagerName().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(password)){
				isUserAvailable = true;
				break;
			}
		}
		return isUserAvailable;
	}
}

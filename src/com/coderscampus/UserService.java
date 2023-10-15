package com.coderscampus;

public class UserService {

	public User createUser(String[] stringInput) {
		User user = new User();
		user.setUsername(stringInput[0]);
		user.setPassword(stringInput[1]);
		user.setName(stringInput[2]);
		return user;
	}

	public String[] parseText (String inputs) {
		String[] splitString = inputs.split(",");
		return splitString;
	}	




}

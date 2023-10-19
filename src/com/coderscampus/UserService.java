package com.coderscampus;

public class UserService {

	public User createUser(String[] stringInput) {
		User user = new User();
		user.setUsername(stringInput[0]);
		user.setPassword(stringInput[1]);
		user.setName(stringInput[2]);
		return user;
	}

	public User validateUsernameAndPassword(String usernameInput, String passwordInput) {
		DataReader users = new DataReader();
		for (User user : users.readData()) {
			if (usernameInput.toLowerCase() == user.getUsername() && passwordInput == user.getPassword()) {
				return user;
			}
		}
		return null;
	}
	
}

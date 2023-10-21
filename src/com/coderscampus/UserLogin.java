package com.coderscampus;

import java.util.Scanner;

public class UserLogin {

	public String UserLogin() {

	        int guessCounter = 0;  // no guess attempt made yet
	        Scanner scanner = new Scanner(System.in);
	        String message = "";

	        while (guessCounter < 5) {
	            System.out.println("Type in your Username:");
	            String usernameInput = scanner.nextLine();
	            System.out.println("Type in your Password:");
	            String passwordInput = scanner.nextLine();

	            UserService userService = new UserService();
	            User validate = userService.validateUsernameAndPassword(usernameInput, passwordInput);

	            if (validate != null) {
	                message = "Welcome " + validate.getName();
	                break;
	            } else {
	                guessCounter++;
	                if (guessCounter < 5) {
	                    message = "Invalid login, please try again.";
	                }
	            }
	        }
	        scanner.close();

	        if (guessCounter == 5) {
	            message = "Too many failed login attempts, you are now locked out.";
	        }

	        return message;
	    }

}

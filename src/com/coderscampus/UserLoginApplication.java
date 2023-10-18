package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		BufferedReader fileReader = null;
		String line = "";
		String[] inputs = null;
		UserService userService = new UserService();
		User[] users = new User[4];
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				// This is where I will read my data into an Array 
				// so that I can compare it later
				inputs = line.split(",");
				users[i] = userService.createUser(inputs);
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, you encountered an I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Closing file reader");
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int guessCounter = 0;  // no guess attempt made yet
		while (guessCounter < 5) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Type in your Username:");
			String usernameInput = scanner.nextLine();
			System.out.println("Type in your Password:");
			String passwordInput = scanner.nextLine();

			for (User user : users) {
				System.out.println(user.getUsername());
				System.out.println(user.getPassword());
				System.out.println(user.getName());

				// valid guess range, check correctness
				if (usernameInput == user.getUsername() && passwordInput == user.getPassword()) {
					System.out.println("Welcome " + user.getName());
					break;
				} else if (guessCounter == 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
					
				} else {
					System.out.println("Invalid login, please try again.");
				}
			guessCounter++;
			}
			scanner.close();
		
		}
		
		// Testing ONLY
//		for (User user : users) {
//			System.out.println("Username: " + user.getUsername());
//			System.out.println("Password: " + user.getPassword());
//			System.out.println("Name: " + user.getName());
//		}
	
		
		
		
	
	
	}

}

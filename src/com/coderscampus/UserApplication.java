package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserApplication {

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

				//Testing Only
//				System.out.println(line);

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
		// Testing ONLY
//		for (User user : users) {
//			System.out.println("Username: " + user.getUsername());
//			System.out.println("Password: " + user.getPassword());
//			System.out.println("Name: " + user.getName());
//		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in your Username:");
		String usernameInput = scanner.nextLine();
		System.out.println("Type in your Password:");
		String passwordInput = scanner.nextLine();

		System.out.println("Username: " + usernameInput + " Password: " + passwordInput);
		
		System.out.println("Closing scanner");
		scanner.close();
		
	
	
	}

}

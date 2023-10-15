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
		String[] stringInputs = null;
		String line = "";
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			while ((line = fileReader.readLine()) != null) {
				// This is where I will read my data into an Array 
				// so that I can compare it later
				System.out.println(line);
				stringInputs = line.split(",");
				UserService userService = new UserService();
				User users = userService.createUser(stringInputs);

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


		

		for (String user : users) {
			System.out.println(users.getUsername());
			System.out.println(users.getPassword());
			System.out.println(users.getName());
		}

		
		
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

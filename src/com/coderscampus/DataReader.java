package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

	public User[] readData() {
	
		BufferedReader fileReader = null;
		String[] inputs = null;
		UserService userService = new UserService();
		User[] users = new User[4];
		String line = "";
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Oops, file not found exception");
			e.printStackTrace();
		}
		try {
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				// This is where I will read my data into an Array 
				// so that I can compare it later
				inputs = line.split(",");
				users[i] = userService.createUser(inputs);
				i++;
			}
		} catch (IOException e) {
			System.out.println("Oops, file I/O exception");
			e.printStackTrace();
		}
	return users;
	}

}

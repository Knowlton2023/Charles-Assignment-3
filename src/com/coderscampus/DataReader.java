package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

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




}

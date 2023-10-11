package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserApplication {

	public static void main(String[] args) {
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, you encountered an I/O Exception");
			e.printStackTrace();
		}
	}

}

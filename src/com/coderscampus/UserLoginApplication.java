package com.coderscampus;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		
//		BufferedReader fileReader = null;
//		String[] inputs = null;
//		UserService userService = new UserService();
//		User[] users = new User[4];
//		String line = "";
//		try {
//			fileReader = new BufferedReader(new FileReader("data.txt"));
//			int i = 0;
//			while ((line = fileReader.readLine()) != null) {
//				// This is where I will read my data into an Array 
//				// so that I can compare it later
//				inputs = line.split(",");
//				users[i] = userService.createUser(inputs);
//				i++;
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("Oops, the file wasn't found");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("Oops, you encountered an I/O Exception");
//			e.printStackTrace();
//		} finally {
//			try {
//				System.out.println("Closing file reader");
//				fileReader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
//		int guessCounter = 0;  // no guess attempt made yet
//		while (guessCounter < 4) {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Type in your Username:");
//			String usernameInput = scanner.nextLine();
//			System.out.println("Type in your Password:");
//			String passwordInput = scanner.nextLine();
//
//			DataReader users = new DataReader();
//			for (User user : users.readData()) {
//				if (usernameInput.toLowerCase() == user.getUsername() && passwordInput == user.getPassword()) {
//					System.out.println("Welcome " + user.getName());
//				} 
//			}
//			
//			guessCounter++;
//			scanner.close();
//		}
		

		int guessCounter = 0;  // no guess attempt made yet
		Scanner scanner = new Scanner(System.in);
		while (guessCounter < 4) {
			System.out.println("Type in your Username:");
			String usernameInput = scanner.nextLine();
			System.out.println("Type in your Password:");
			String passwordInput = scanner.nextLine();

			UserService userService = new UserService();
			User validate = userService.validateUsernameAndPassword(usernameInput, passwordInput);

			if (validate != null){
				System.out.println("Welcome " + validate.getName());
				break;
			} else {
				System.out.println("Invalid login, please try again.");
			}
			
			guessCounter++;
		}
		scanner.close();
		
		if (guessCounter == 5) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
		
		
		
		
	
	
	}

}

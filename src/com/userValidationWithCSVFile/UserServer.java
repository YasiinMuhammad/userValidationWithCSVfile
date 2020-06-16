package com.userValidationWithCSVFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserServer {

	public static void main(String[] args) {
		UserService userService = new UserService();

		UserLogin[] users = new UserLogin[4];

		for (int i = 0; i < 4; i++) {
			users[i] = userService.createUser("username" + (i + 1), "password" + (i + 1), "name" + (i + 1));
		}

		Scanner userInput = new Scanner(System.in);

		String usersname;
		String password;
		String line = ""; 

		BufferedReader dataReader = null;
		try {
			dataReader = new BufferedReader(new FileReader("data.txt"));

			while ((line = dataReader.readLine()) != null) {
				System.out.println(line);
				String[] userData = line.split(","); 
				UserLogin user = new UserLogin();
				user.setUsername(userData[0]);
				user.setPassword(userData[1]);
				user.setName(userData[2]);
				
				System.out.println(userData);
				
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Enter your email: ");
		usersname = userInput.nextLine();

		System.out.println("Enter your password: ");
		password = userInput.nextLine();

		if (usersname.equals(line) && (password.equals(line))) {
			System.out.println("Welcome ");
		} else {
			System.out.println("Invalid login, please try again.");
		}

		userInput.close();

	}

}

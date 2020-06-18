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

		Scanner userInput = new Scanner(System.in);

		String username;
		String password;

		BufferedReader dataReader = null;
		try {
			int i = 0;
			String line = null;
			dataReader = new BufferedReader(new FileReader("data.txt"));
			while ((line = dataReader.readLine()) != null) {
				String[] userData = line.split(",");
				UserLogin user = new UserLogin();
				user.setUsername(userData[0]);
				user.setPassword(userData[1]);
				user.setName(userData[2]);
				users[i] = user;
				i++;

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		boolean val = false;
		int logAttemps = 0;
		while (logAttemps < 5 && !val) {
			System.out.println("Enter your email: ");
			username = userInput.nextLine();

			System.out.println("Enter your password: ");
			password = userInput.nextLine();

			UserLogin isVal = userService.createUser(users, username, password);

			if (isVal != null) {
				System.out.println("Welcome: " + isVal.getName());
				val= true;
			} else {
				System.out.println("Invalid login, please try again.");
				logAttemps++;
				if (logAttemps >= 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
				}
			}
		}

		userInput.close();

	}

}

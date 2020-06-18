package com.userValidationWithCSVFile;

public class UserService {

	public UserLogin createUser(UserLogin[] users, String username, String password) {

		for (UserLogin user : users) {

			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}

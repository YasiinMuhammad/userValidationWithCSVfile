package com.userValidationWithCSVFile;

public class UserService {
	
	public UserLogin createUser (String username, String password, String name) {
		UserLogin user = new UserLogin();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		
		return user;
	}
}

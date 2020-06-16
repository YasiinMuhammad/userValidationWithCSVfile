 package com.userValidationWithCSVFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserDataValidation {

	public static void main(String[] args) {
		BufferedReader dataReader = null;
		try {
			dataReader = new BufferedReader(new FileReader("data.txt"));

			String line = "";
			while ((line = dataReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("had a io exception");
			e.printStackTrace();
		} finally {
			try {
				dataReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

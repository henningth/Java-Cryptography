/*
Example with salting a password before hashing, in order to make lookup tables infeasible
*/

import java.security.SecureRandom;
import java.security.MessageDigest;

import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class HashingSalt {
	
	public static void main(String[] args) {
		
		try {
			// User enters password in cleartext
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter password: ");
			String password = userInput.nextLine();
			
			// Makes a string of allowed alphanumerics
			String symbols = "ABCDEFGJKLMNPRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; 
			
			// System draws salt as a random string of same length as password
			int passwordLength = password.length();
			SecureRandom secureRandom = new SecureRandom();
			
			char[] saltTemp = new char[passwordLength];
			
			for (int idx = 0; idx < saltTemp.length; ++idx) 
				saltTemp[idx] = symbols.charAt(secureRandom.nextInt(symbols.length()));
	
			String salt = new String(saltTemp);
			
			System.out.println("Salt: " + salt);
			
			// Salt is concatenated to password
			String saltedPassword = password + salt;
			
			// Compute hash of concatenated password
			MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
			
			byte[] hashedSaltedPassword = SHA256.digest(saltedPassword.getBytes("UTF-8"));
			String hashedSaltedPasswordSHA256 = DatatypeConverter.printHexBinary(hashedSaltedPassword);
			
			System.out.println("Hashed salted password:");
			System.out.println(hashedSaltedPasswordSHA256);
			
		} catch(Exception Ex) {
			
			Ex.printStackTrace();
			
		}

		
	}
	
}
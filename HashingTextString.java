/*
This program takes as input a text string, and returns the hash of it.

The hash is one of:
MD5, SHA1, SHA256
*/

import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import java.security.MessageDigest;

public class HashingTextString {
	
	public static void main(String[] args) {
		
		try {
			
			byte[] hashedText;
			char choice;
			
			Scanner userInput = new Scanner(System.in);
			
			// User provides an input string
			System.out.println("Enter text to be hashed: ");
			String clearText = userInput.nextLine();
			
			// User chooses between hash functions
			System.out.println("Choose hash function: ");
			choice = (char) System.in.read();
			
			// Computes the user-specified hash of the input string and print it
			switch(choice) {
				case '1': // MD5
					MessageDigest messageDigestMD5 = MessageDigest.getInstance("MD5");
					hashedText = messageDigestMD5.digest(clearText.getBytes("UTF-8"));
					String hashTextMD5 = DatatypeConverter.printHexBinary(hashedText);
					
					System.out.println("Hashed text using MD5: ");					
					System.out.println(hashTextMD5);
					break;
				case '2': // SHA1
					MessageDigest messageDigestSHA1 = MessageDigest.getInstance("SHA-1");
					hashedText = messageDigestSHA1.digest(clearText.getBytes("UTF-8"));
					String hashTextSHA1 = DatatypeConverter.printHexBinary(hashedText);
					
					System.out.println("Hashed text using SHA-1: ");
					System.out.println(hashTextSHA1);
					break;
				case '3': // SHA256
					MessageDigest messageDigestSHA256 = MessageDigest.getInstance("SHA-256");
					hashedText = messageDigestSHA256.digest(clearText.getBytes("UTF-8"));
					String hashTextSHA256 = DatatypeConverter.printHexBinary(hashedText);
					
					System.out.println("Hashed text using SHA-256: ");
					System.out.println(hashTextSHA256);
					break;					
			}
			
			userInput.close();
						
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
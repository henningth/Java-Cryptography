/*
 * Example of encryption and decryption of a simple message text using 
 * Advanced Encryption Standard (AES).
 */

import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;

public class AES {
	
	public static void main(String[] args) {
		
		try {
		
		// Message (cleartext) to be encrypted
		byte[] clearText = "Cleartext (encryption using AES)".getBytes("UTF-8");
		System.out.println("Cleartext: " + new String(clearText));
				
		// Define key generator (AES)
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		
		// Key size in bits
		keyGen.init(128);
		
		// Generate a key
		Key secretKey = keyGen.generateKey();
		
		// Generate cipher
		Cipher cipher = Cipher.getInstance("AES");
		
		// Initialize cipher to work in encryption mode
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		// Encrypt cleartext
		byte[] cipherText = cipher.doFinal(clearText);
		System.out.println("Ciphertext: " + new String(cipherText));
		
		// Initialize cipher to work i decryption mode
		cipher.init(Cipher.DECRYPT_MODE, secretKey, cipher.getParameters());
		
		// Decrypt ciphertext
		byte[] decryptedText = cipher.doFinal(cipherText);
		System.out.println("Decrypted text: " + new String(decryptedText));
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
}
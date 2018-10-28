/*
Example encrypting and decrypting a text string using RSA.

*/

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class RSA {
	
	public static void main(String[] args) {
		
		try {
			
			// Message to be encrypted
			byte[] clearText = "This text is to be encrypted using RSA".getBytes("UTF-8");
			System.out.println("Clear text: " + new String(clearText));
			
			// Generate private and public key pair
			// Define key generator (RSA)
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			
			// Initialize the key pair generator
			keyPairGen.initialize(1024, new SecureRandom());
			
			// Generate private and public key
			KeyPair keyPair = keyPairGen.generateKeyPair();
			
			// Define cipher (RSA)
			Cipher cipher = Cipher.getInstance("RSA");
			
			// Initialize cipher to work in encryption mode (uses the public key)
			cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
			
			// Encrypt the text using the public key and prints it
			byte[] cipherText = cipher.doFinal(clearText);
			System.out.println("Cipher text: " + new String(cipherText));
			
			// Initialize the cipher to work in decryption mode (uses the private key)
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
			
			// Decrypt the text using the private key and prints it
			byte[] decryptedText = cipher.doFinal(cipherText);
			System.out.println("Decrypted text: " + new String(decryptedText));
			
		} 
		
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
}
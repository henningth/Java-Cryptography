// This program encrypts and decrypts a text using DES.
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class DES {
	
	public static void main(String[] args) {
		
		try
		{
	
    		// Define message (cleartext) to be encrypted
		byte[] clearText = "Hello Crypto World".getBytes("UTF-8");
		System.out.println("Cleartext: " + new String(clearText));
			
		// Define generator for key (AES or DES)	
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56);
		
		// Generate a key from the generator
		Key secretKey = keyGen.generateKey();
		
		// Generate cipher (specify which algorithm to use)
		Cipher cipher = Cipher.getInstance("DES");
		
		// Initializes cipher to work in encryption mode
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		// Encrypt (map to ciphertext)
		byte[] cipherText = cipher.doFinal(clearText);
		System.out.println("Ciphertext: " + new String(cipherText));
		
		// Initialize cipher to decryption mode
		cipher.init(Cipher.DECRYPT_MODE, secretKey, cipher.getParameters());
		
		// Decrypt (map to cleartext)
		byte[] decryptedText = cipher.doFinal(cipherText);		
		System.out.println("Decrypted text: " + new String(decryptedText));
		
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}

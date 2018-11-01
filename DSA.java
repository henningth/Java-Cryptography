/*
Example with the Digital Signature Algorithm (DSA)

Alice signs her message using DSA (private key), and Bob verifies the signed message 
using his public key.
*/

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.SecureRandom;
import javax.crypto.Cipher;

public class DSA {

	public static void main(String[] args) {
		
		try {
			
			// Generate a signature instance
			Signature signature = Signature.getInstance("SHA256withDSA");
			
			// Generate a secure random instance
			SecureRandom secureRandom = new SecureRandom();
			
			// Initialize keys
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
			
			// Generate public and private keys
			KeyPair keyPair = keyPairGen.generateKeyPair();
			
			// Save private and public keys
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();
			
			// Message to be signed
			byte[] aliceMessage = "This message is to be signed".getBytes("UTF-8");
			
			// Generate signature for the data
			signature.initSign(privateKey, secureRandom);
			
			// Sign the message
			signature.update(aliceMessage);
			byte[] digitalSignature = signature.sign();
			
			// Verify the message
			signature.initVerify(publicKey);
			byte[] bobMessage = "This message is to be signed".getBytes("UTF-8");
			signature.update(bobMessage);
			
			boolean verified = signature.verify(digitalSignature);
			
			if(verified == true) {
				System.out.println("Message is authentic.");
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
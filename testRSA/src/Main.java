import java.security.*;
import javax.crypto.Cipher;

public class Main {
	
	public static void main(String[] args) throws GeneralSecurityException {
		
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		KeyPair kp = kpg.genKeyPair();
		PublicKey pubKey = kp.getPublic();
		PrivateKey privKey = kp.getPrivate();
				
		Cipher cipher = Cipher.getInstance("RSA");		
		
		// ci¹g 10101010...
		byte[] tekst = {-86,-86,-86,-86};
		
		
		for(int i = 0; i < tekst.length; i++) {
			System.out.print(MyByte.toBinaryString(tekst[i]) + " ");
		}
		
		//----------------------------------------------
		System.out.println("\n\nencrypting...");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] cipherData = cipher.doFinal(tekst);	    
		
		for(int i = 0; i < cipherData.length; i++) {
			System.out.print(MyByte.toBinaryString(cipherData[i]) + " ");
		}
		System.out.println("\nencryption done");
		
		//--------------------------------------------------
		System.out.println("\ndecrypting...");
		cipher.init(Cipher.DECRYPT_MODE, privKey);
		byte[] odszyfrowany = cipher.doFinal(cipherData);
		
		for(int i = 0; i < odszyfrowany.length; i++) {
			System.out.print(MyByte.toBinaryString(odszyfrowany[i]) + " ");
		}
		
		System.out.println("\ndecryption done");			
	}
}
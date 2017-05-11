import javax.crypto.*;
import java.util.Base64;
public class Encrypt {
	static Cipher cipher;
	
	public static void main(String[] args) throws Exception {

		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
      

        String plainText = "AES Symmetric Encryption Decryption";
        System.out.println("Plain Text Before Encryption: " + plainText);

        String encryptedText = encryptText(plainText, secretKey);
        System.out.println("Encrypted Text After Encryption: " + encryptedText);

        String decryptedText = decryptText(encryptedText, secretKey);
        System.out.println("Decrypted Text After Decryption: " + decryptedText);
		
	}  
	public Encrypt(){
		
	}
	
	public static String encryptText(String plainText, SecretKey secretKey)
            throws Exception {
		  cipher = Cipher.getInstance("AES");
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }
	
	public static String decryptText(String encryptedText, SecretKey secretKey)
            throws Exception {
		  cipher = Cipher.getInstance("AES");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }

}

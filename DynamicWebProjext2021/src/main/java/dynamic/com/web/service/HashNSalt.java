package dynamic.com.web.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


public class HashNSalt {
	
	//checks if the user's password matches with the hashed and salted password from the database
	public static Boolean CheckForEquality(String userPassword,String salt,String hashedNSaltedPassword) {
		
		Boolean result = false;
		byte[] theSalt = Base64.getDecoder().decode(salt);
		String value = getSecurePassword(userPassword,theSalt);
		//System.out.println("user pass with salt and hashed is "+ value);
		//System.out.println("pass in db is "+hashedNSaltedPassword);
		//System.out.println("salt is "+salt + "also is (bytes)" + Base64.getDecoder().decode(salt));
		if(value.equals(hashedNSaltedPassword)) {
			
			result = true;
		}
		return result;
	}
	//creates hashed + salted Password
    public static String getSecurePassword(String password, byte[] salt) {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    // generates salt
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    
    }
	  public static void main(String[] args) throws NoSuchAlgorithmException {
	  
	    // same salt should be passed 
		 byte[] salt = Base64.getDecoder().decode("kcS/w61jDTIBXQsgrkn/tw==");
		 String hashedNsaletedp= "764bb6e8eb6d66e9be088ca919870813070f29672bf82fd39f48f8fe67eff61c";
		 String string_salt = Base64.getEncoder().encodeToString(salt);
		 String password1 = getSecurePassword("121", salt); 
		// String password2 = getSecurePassword("123",salt); 
		// System.out.println(" Password 1 -> " + password1);
	     //System.out.println(" Password 2 -> " + password2);
		 
	     if(password1.equals(hashedNsaletedp)) {
	    	// System.out.println("passwords are equal and salt is "+ Base64.getEncoder().encodeToString(salt)); 
	    }
	    //System.out.println( CheckForEquality("1",string_salt,hashedNsaletedp)); 
	     }
	 
}
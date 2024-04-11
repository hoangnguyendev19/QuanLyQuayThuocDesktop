package util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encode {
	   
    public static String md5Encode(String text) {
    	String encodeString = null ;
        try {
			
			MessageDigest msd = MessageDigest.getInstance("MD5");
			
			byte[] textBytes = text.getBytes("UTF-8");
			byte[] encodeBytes  =msd.digest(textBytes);
			
			BigInteger bigInt =new BigInteger(1,encodeBytes);
			encodeString = bigInt.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return encodeString;
    }
}

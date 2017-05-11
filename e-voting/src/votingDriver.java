import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class votingDriver {
	



	public static void main(String[] args) throws Exception {
		voterUI.createAndShowGUI(true, false);
//		database.encryptVPass();
//		database.encryptEPass();
		
		
//		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//	      keyGenerator.init(128);
//	      final SecretKey secretKey = keyGenerator.generateKey();
//	;
//	 database.voterFileEncrpt(secretKey);
//	 database.eOfficerFileEncrpt(secretKey);
//     database.candFileEncrpt(secretKey);
//
//	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//	        	
//	            public void run() {
//	            	
//	                try {
//	           	     database.voterFileDecrypt(secretKey);
//		           	 database.eOfficerFileDecrypt(secretKey);
//		     	     database.candFileDecrypt(secretKey);
//		     	     voterUI.createAndShowGUI(true,false);
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	            }
//	        });
//	    
//	     
//	        System.out.print("DECRYPTING");
//	        
//	        database.voterFileEncrpt(secretKey);
//		
//		 database.eOfficerFileEncrpt(secretKey);
//	     database.candFileEncrpt(secretKey);
		 
		
	}
		

}
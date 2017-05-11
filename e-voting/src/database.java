import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.SecretKey;

import com.mkyong.test.MD5HashingExample;


public class database {
	private static  ArrayList <candidate>canList = new ArrayList<candidate>();
//	private static ArrayList <voter> voterList = new ArrayList<voter>();
//	private static ArrayList <electionOfficer> electionOfficer = new ArrayList<electionOfficer>(); 
//	private int numVoters = voterList.size();
//	static int totalVotes =0;
	
//	ArrayList <candidate>canList
	public database(){
		
	}
	public void notVoted(String voterID) throws IOException{
		File originalFile = new File("voter.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     
	     String hasVoted = "false";
	     String line = null;
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	             if (line.contains(voterID)) {

	            	 //Gets the last item in the list using the commma.and trims all white space
//	            	 this is the has voted section of the file
	                 String currentHasVoted = line.substring(line.lastIndexOf(","), line.length()-1).replaceAll(",","").trim();
//	                 replaces old hasvoted field in the voter object.
	                 line = line.substring(0,line.lastIndexOf(",")) + "," + hasVoted + ".";
	                 System.out.println("new  line " + line);
	             
	                 
	             }
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");

	     
		
	}
	public String voted(String voterID) throws IOException{
		File originalFile = new File("voter.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     
	     String hasVoted = "true";
	     String line = null;
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	             if (line.contains(voterID)) {

	            	 //Gets the last item in the list using the commma.and trims all white space
//	            	 this is the has voted section of the file
	                 String currentHasVoted = line.substring(line.lastIndexOf(","), line.length()-1).replaceAll(",","").trim();
//	                 replaces old hasvoted field in the voter object.
	                 line = line.substring(0,line.lastIndexOf(",")) + "," + hasVoted + ".";
	                 System.out.println("new  line " + line);
	             
	                 
	             }
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return voterID;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile)){
	         System.out.println("Could not rename file");
	     }
	     return voterID;
	     
		
	}
public static void addVote(String candidateID) throws IOException{
	 int addvote  = 1;

     File originalFile = new File("candidate.txt");
     BufferedReader br = new BufferedReader(new FileReader(originalFile));

     // Construct the new file that will later be renamed to the original
     // filename.
     File tempFile = new File("tempfile.txt");
     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

     String line = null;
     // Read from the original file and write to the new
     // unless content matches data to be removed.
     while ((line = br.readLine()) != null) {

         if (line.contains(candidateID)) {

        	 //Gets the last item in the list using the commma.and trims all white space
             String strCurrentVote = line.substring(line.lastIndexOf(","), line.length()-1).replaceAll(",","").trim();
             
             //checks to see if this last space is empty.
             if (strCurrentVote != null || !strCurrentVote.trim().isEmpty()) {
            	 //create a new vote var to store the old vote with new vote added.
                 int newVote = Integer.parseInt(strCurrentVote.trim()) + addvote;
//                 print out the new vote
//                 System.out.println("new vote : " + newVote);
                 //add ", newVote."  to the index of the last comma
                 line = line.substring(0,line.lastIndexOf(",")) + "," + newVote + ".";
//                 System.out.println("Current Vote: " + line);
             }

         }
         pw.println(line);
         pw.flush();
     }
     pw.close();
     br.close();

     // Delete the original file
     if (!originalFile.delete()) {
         System.out.println("Could not delete file");
         return;
     }

     // Rename the new file to the filename the original file had.
     if (!tempFile.renameTo(originalFile))
         System.out.println("Could not rename file");

 
}
	public void addCand(candidate can){
		canList.add(can);
		
	}
	
	public static  void addCand(int index,candidate can){
		canList.add(index, can);
		
	}
	
	
	
	public void removeCand(candidate can){
		canList.remove(can);
		
	}
	
	public static candidate getCand(int index){
		return canList.get(index);
	}
	
	
	
	
//	***********************************ENCRPTION / DECRYPTION**************************************************************************


	
	public static void encryptVPass() throws IOException, NoSuchAlgorithmException{
		File originalFile = new File("voter.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     
	     String hasVoted = "true";
	     String line = null;
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {
	        	 String[] voterInfo = line.split(",");

	        	 String currentID = voterInfo[0].trim();

	        	 String currentName = voterInfo[1].trim();

	        	 String currentSS = voterInfo[3].trim();
	        	 System.out.println("encrypting ss " + currentSS);
	        	 String voted = voterInfo[4];

	        	String hashCurrentSS = MD5HashingExample.convert(currentSS);

	        	 System.out.println("hased ss " + hashCurrentSS);

	        	line = currentID + ","+ currentName + ","+"21," + hashCurrentSS +"," + voted ;
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");

	}
	
	
	public static void encryptEPass() throws IOException, NoSuchAlgorithmException{
		File originalFile = new File("ElectionOfficer.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     
	     String hasVoted = "true";
	     String line = null;
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {
	        	 String[] eInfo = line.split(",");

	        	 String currentOffID = eInfo[0];

	        	 String currentOffffName = eInfo[1];

	        	 String currentPass = eInfo[2].trim();
	        	 System.out.println("encrypting ss " + currentPass);
	        	

	        	String hashCurrentPass = MD5HashingExample.convert(currentPass);

	        	 System.out.println("hased ss " + hashCurrentPass);

	        	line = currentOffID + ","+ currentOffffName + "," + hashCurrentPass;
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");

	}
	
	static Encrypt encryptor = new Encrypt();
	public static void voterFileEncrpt(SecretKey secretKey) throws Exception{


//      cipher = Cipher.getInstance("AES");
		
		File originalFile = new File("voter.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     

	     String line = null;
//	 	String nextLine = resultsScanner.nextLine();
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	    
	     

	            	 //Gets the last item in the list using the commma.and trims all white space
//	        
//	                 replaces old hasvoted field in the voter object.
	        	 System.out.println("current line " + line);
	        	 String encryptedText = encryptor.encryptText(line, secretKey);
	        	 System.out.println("encryptedText " + encryptedText);
	        	 line = encryptedText;
	        	 System.out.println("new line " + line);
	        	 
	  
	                
	             
	                 
	             
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");;
//		read through all the lines

		
				
		}
	public static void voterFileDecrypt(SecretKey secretKey) throws Exception{

//		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//      keyGenerator.init(128);
//      SecretKey secretKey = keyGenerator.generateKey();
////      cipher = Cipher.getInstance("AES");
		
		File originalFile = new File("voter.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     

	     String line = null;
//	 	String nextLine = resultsScanner.nextLine();
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	          

	            	 //Gets the last item in the list using the commma.and trims all white space
//	        
//	                 replaces old hasvoted field in the voter object.
	        	 System.out.println("current encrypted line " + line);
	        	 String decryptedText = Encrypt.decryptText(line, secretKey);
	             System.out.println("decrypted  line " + decryptedText);
	             line = decryptedText;
	             
	             System.out.println(" new decrypted line "+  line);    
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");;
//		read through all the lines

		
				
		}
	public static void eOfficerFileEncrpt(SecretKey secretKey) throws Exception{


//      cipher = Cipher.getInstance("AES");
		
		File originalFile = new File("ElectionOfficer.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     

	     String line = null;
//	 	String nextLine = resultsScanner.nextLine();
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	          

	            	 //Gets the last item in the list using the commma.and trims all white space
//	        
//	                 replaces old hasvoted field in the voter object.
	        	 System.out.println("current line " + line);
	        	 String encryptedText = encryptor.encryptText(line, secretKey);
	        	 System.out.println("encryptedText " + encryptedText);
	        	 line = encryptedText;
	        	 System.out.println("new line " + line);
	                 
	             
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");;
//		read through all the lines

		
				
		}
	public static void eOfficerFileDecrypt(SecretKey secretKey) throws Exception{

//		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//      keyGenerator.init(128);
//      SecretKey secretKey = keyGenerator.generateKey();
////      cipher = Cipher.getInstance("AES");
		
		File originalFile = new File("ElectionOfficer.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     

	     String line = null;
//	 	String nextLine = resultsScanner.nextLine();
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	          

	            	 //Gets the last item in the list using the commma.and trims all white space
//	        
//	                 replaces old hasvoted field in the voter object.
	        	 System.out.println("current encrypted line " + line);
	        	 String decryptedText = Encrypt.decryptText(line, secretKey);
	             System.out.println("decrypted  line " + decryptedText);
	             line = decryptedText;
	             
	             System.out.println(" new decrypted line "+  line);    
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");;
//		read through all the lines

		
				
		}
	
	
		
	public static void candFileEncrpt(SecretKey secretKey) throws Exception{


//      cipher = Cipher.getInstance("AES");
		
		File originalFile = new File("candidate.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     

	     String line = null;
//	 	String nextLine = resultsScanner.nextLine();
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	          

	            	 //Gets the last item in the list using the commma.and trims all white space
//	        
//	                 replaces old hasvoted field in the voter object.
	        	 System.out.println("current line " + line);
	        	 String encryptedText = encryptor.encryptText(line, secretKey);
	        	 System.out.println("encryptedText " + encryptedText);
	        	 line = encryptedText;
	        	 System.out.println("new line " + line);
	             
	                 
	             
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");;
//		read through all the lines

		
				
		}
	public static void candFileDecrypt(SecretKey secretKey) throws Exception{

//		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//      keyGenerator.init(128);
//      SecretKey secretKey = keyGenerator.generateKey();
////      cipher = Cipher.getInstance("AES");
		
		File originalFile = new File("candidate.txt");
	     BufferedReader br = new BufferedReader(new FileReader(originalFile));

	     // Construct the new file that will later be renamed to the original
	     // filename.
	     File tempFile = new File("tempfile.txt");
	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	   //creates the scanner that reads the file
	     Scanner vScanner = new Scanner(originalFile);
	     

	     String line = null;
//	 	String nextLine = resultsScanner.nextLine();
	    	// Read from the original file and write to the new
	         // unless content matches data to be removed.
	         while ((line = br.readLine()) != null) {

	          

	            	 //Gets the last item in the list using the commma.and trims all white space
//	        
//	                 replaces old hasvoted field in the voter object.
	        	 System.out.println("current encrypted line " + line);
	        	 String decryptedText = Encrypt.decryptText(line, secretKey);
	             System.out.println("decrypted  line " + decryptedText);
	             line = decryptedText;
	             
	             System.out.println(" new decrypted line "+  line);    
	     
	         pw.println(line);
	         pw.flush();
	     }
	     pw.close();
	     br.close();

	     // Delete the original file
	     if (!originalFile.delete()) {
	         System.out.println("Could not delete file");
	         return;
	     }

	     // Rename the new file to the filename the original file had.
	     if (!tempFile.renameTo(originalFile))
	         System.out.println("Could not rename file");;
//		read through all the lines

		
				
		}
//	public static int getTotalVotes(){
//		
//		for(int i = 0; i< canList.size(); i++){
//		totalVotes = totalVotes + canList.get(i).getVotes(); 
//		}
//		return totalVotes;
//	}
	
	
//	public static void printResults(){
//		for(int i = 0; i< canList.size(); i++){
//			System.out.println("Candiate Name: " + canList.get(i).getCandName());
//			System.out.println("Candidate Party: " + canList.get(i).getCandidateParty());
//			System.out.println("Candidate Votes: " + canList.get(i).getVotes());
//		}
//		System.out.println("Total Votes: "+ database.getTotalVotes());
//	}
//	

	

}

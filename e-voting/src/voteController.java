import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Task: handles interaction between the voter and the voterUI (display)
//Input: Several inputs to handle interaction
//Output: actions

public class voteController {
	private Voter voter;
	
	public voteController(){
		
	}
	public voteController(Voter voter){
		this.voter = voter;
	}
//	Purpose: returns true if login is valid
//	Preconditions: takes in login information to verify
//	Postconditions: returns true or false
	public boolean approvelogin( String lineSplit){
		System.out.println("VINFO: "+ lineSplit.split(",")[3]+ " GIVEN: " + voter.getVoterSS());
		System.out.println("VoterID: " + lineSplit.split(",")[0].trim() + " GIVEN: " + voter.getVoterID());
		System.out.println("VOTER NAME: " + lineSplit.split(",")[1].trim() + " GIVEN: " + voter.getVoterName()) ;
		System.out.println("VOTER AGE: " + lineSplit.split(",")[2].trim() + " GIVEN: " + voter.getAge());
		
		
		
		boolean sol = false;
			if(lineSplit.split(",")[3].trim().equals( voter.getVoterSS()) && 
					lineSplit.split(",")[0].trim().equals(( voter.getVoterID())) &&
					lineSplit.split(",")[1].trim().equals( voter.getVoterName()) && 
					 Integer.parseInt(lineSplit.split(",")[2].trim()) == voter.getAge() &&
							 Integer.parseInt(lineSplit.split(",")[2].trim()) >= 18){
				sol = true;
				}
			
		return sol;
					
	}
//	public void voted(String voterID) throws IOException{
//		File originalFile = new File("voter.txt");
//	     BufferedReader br = new BufferedReader(new FileReader(originalFile));
//
//	     // Construct the new file that will later be renamed to the original
//	     // filename.
//	     File tempFile = new File("tempfile.txt");
//	     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
//	   //creates the scanner that reads the file
//	     Scanner vScanner = new Scanner(originalFile);
//	     
//	     String hasVoted = "true";
//	     String line = null;
//	    	// Read from the original file and write to the new
//	         // unless content matches data to be removed.
//	         while ((line = br.readLine()) != null) {
//
//	             if (line.contains(voterID)) {
//
//	            	 //Gets the last item in the list using the commma.and trims all white space
////	            	 this is the has voted section of the file
//	                 String currentHasVoted = line.substring(line.lastIndexOf(","), line.length()-1).replaceAll(",","").trim();
////	                 replaces old hasvoted field in the voter object.
//	                 line = line.substring(0,line.lastIndexOf(",")) + "," + hasVoted + ".";
//	                 System.out.println("new  line " + line);
//	             
//	                 
//	             }
//	     
//	         pw.println(line);
//	         pw.flush();
//	     }
//	     pw.close();
//	     br.close();
//
//	     // Delete the original file
//	     if (!originalFile.delete()) {
//	         System.out.println("Could not delete file");
//	         return;
//	     }
//
//	     // Rename the new file to the filename the original file had.
//	     if (!tempFile.renameTo(originalFile))
//	         System.out.println("Could not rename file");
//
//	     
//		
//	}
	
	
	
	
//	Takes in a String voterID and creates a Voter object if the ID is found in the database and returns "ID Found" to console 
//	if not found NOT REGISTERED is returned to console
//	******READS VOTER TXT******
	public Voter readVoter(String voterID){
		 String voteIDInput = voterID;
	     File originalFile = new File("voter.txt");

	     
		Voter v = new Voter();
		
		try {
			
			Scanner vScanner = new Scanner(originalFile);
			
			//reads the first line of the file.
			
			
			while(vScanner.hasNextLine()){
//				****DECRPT HERE****
			//Creates a list of strings for the current line of Officer ID info
				
				String nextLine = vScanner.nextLine();
				
//				get information from the file
				String[] voterInfo = nextLine.split(",");
				String currentID = voterInfo[0];
				String currentName = voterInfo[1];
				String currentSS = voterInfo[3];
				String voted = voterInfo[4].substring(0, voterInfo[4].length()-1);
				boolean currentVoted = Boolean.parseBoolean(voted );


//				create a new Voter object with the information from the file as inputs 
				v = new Voter(currentID,currentName,21,currentSS,currentVoted);
				
//				if the id from the file is equal to the voterid from the input set the voter info to the one from the file
					if(currentID.equals(voteIDInput)){
						v.setVoterID(currentID);
						v.setVoterName(currentName);
						v.setVoterSS(currentSS);
						v.setHasVoted(currentVoted);
						break;
					}
				
					else{
//						if the voter id from the file and the voter if from input are not the same create a new voter object
						v = new Voter();
						
					}
			}
			//end while loop
			if(v.getVoterID() == null){
				System.out.println("Not Registered");
			}
			else{
//			System.out.println("Voter " + v.getVoterName());
				System.out.println("ID Found");
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}
	
	public Voter getVoter(){
		return voter;
		
	}
	public void login(){
		
	}
	
	

	

}

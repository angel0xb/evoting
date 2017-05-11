import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.print.*;


public class electionOfficer {
//	voter ID contains the ID of an election officer as an int.
	private String officerID;
//	vovterName contains the full name of the officer
	public String officerName;
// contains the password of the officer
	public String officerPassword;
	
	public electionOfficer(){
		
	}
	
	public electionOfficer( String offID, String offName, String offPass){
		
		setOfficerID(offID);
		officerName = offName;
		officerPassword = offPass;
		
	}
	
//	Purpose:logs the user in uses approve login
//	Preconditions: use login information for the voter
//	Postconditions: use is logged in
	public void login(){
//		if(electionOfficer)
	}

//	Purpose:displays the currents results 
//	Preconditions:
//	Postconditions: gets the results for viewing 
	public void viewResults() throws FileNotFoundException{
		File resultsFile = new File("candidate.txt");
		
		Scanner resultsScanner = new Scanner(resultsFile);
		while(resultsScanner.hasNextLine()){
			System.out.println(resultsScanner.nextLine());
		}
	}
	
//	Purpose:printns out current results 
//	Preconditions: takes in a String array of the results 
//	Postconditions: prints out the results 
	public void printResults(String[] results){}

	public String getID() {
		return officerID;
	}

	public void setOfficerID(String officerID) {
		this.officerID = officerID;
	} 
	
	public String getName(){
		return officerName;
	}
	
	public void setName(String name){
		this.officerName = name;
	}
	
	public void setPass(String pass){
		this.officerPassword = pass;
	}
	
	public String getPass(){
		return officerPassword;
	}
}

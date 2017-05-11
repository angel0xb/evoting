import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class electionOfficeHandler {
	private electionOfficer officer;
//	private ElectionOfficerHandler handler;
	
	public electionOfficeHandler(){}
	
	public electionOfficeHandler(electionOfficer officer){
		this.officer = officer;
	}
//	*****READS ELECTION OFFICER TXT FILE*****
	public electionOfficer readOfficer(String userInput){
//		String fileLocation = File.separator + "Users" + File.separator + "wyattmorris" + File.separator + "git" + File.separator +  "e-voting" + File.separator +  "ElectionOfficer.txt";
		//creates variable for the text file
		File OfficerFile = new File("ElectionOfficer.txt");
	
			
			electionOfficer elec = new electionOfficer();
			
			try {
				//creates the scanner that reads the file
				Scanner officerScanner = new Scanner(OfficerFile);
				while(officerScanner.hasNextLine()){			
					//reads the first line of the file.
					String nextLine = officerScanner.nextLine();
			
				
					//Creates a list of strings for the current line of Officer ID info
					String[] officerIDInfo = nextLine.split(",");
					String currentID = officerIDInfo[0];
					String currentName = officerIDInfo[1];
					String currentPW = officerIDInfo[2];
					
					elec = new electionOfficer(currentID, currentName,currentPW);
					//System.out.print("Officerr Name " + elec.getName() + " ");


					if(currentID.equals(userInput)){
						elec.setOfficerID(currentID);
						elec.setName(currentName);
						elec.setPass(currentPW);
						break;
					}
					else{
						elec = new electionOfficer();
					}
					
				}
				//end while loop
				if(elec.getName() == null){
					System.out.println("Officer ID not found.");
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return elec;
		
		
		
	}
	
//	*******READS VOTER TXT FILE*******
	 public String votingPercentage() throws FileNotFoundException{
		 File originalFile = new File("voter.txt");
//	     BufferedReader br = new BufferedReader(new FileReader(originalFile));
	     
		Voter v = new Voter();
		
		
			//creates the scanner that reads the file
			Scanner vScanner = new Scanner(originalFile);
			
			//reads the first line of the file.
			
			double amountVoters=0;
			double amountVoted = 0;
			while(vScanner.hasNextLine()){
			//Creates a list of strings for the current line of Officer ID info
				
				String nextLine = vScanner.nextLine();
				
				
				String[] voterInfo = nextLine.split(",");
				String currentID = voterInfo[0];
				String currentName = voterInfo[1];
				String currentSS = voterInfo[3];
				String voted = voterInfo[4].substring(0, voterInfo[4].length()-1);
//				boolean currentVoted = Boolean.parseBoolean(voted );
//				System.out.println("amount of voters " + amountVoters );
				amountVoters++;
				
				if(voted.equals("true")){
//					System.out.println("amount Voted " + amountVoted);
					amountVoted++;
					
					}
				
				
				}
			amountVoters = amountVoters -1;
			System.out.println("amount of voters " + amountVoters);
			System.out.println("amount Voted " + amountVoted);
			double rtn = (amountVoted / amountVoters) * 100;
			System.out.println("return " + rtn);
			String stringRtn = Double.toString(rtn  );
		return "Amount of voters: " + amountVoters +
		"\n\nAmount Voted: " + amountVoted +"\n\nVoting Percentage: " + stringRtn + "%";
		 
	 }

	



	
    public static void main(String[] args) throws FileNotFoundException {
    	
    	electionOfficer officer = new electionOfficer();
    	electionOfficeHandler  o = new electionOfficeHandler(officer);
    	System.out.println(o.votingPercentage());
    }
	

}


public class Voter {
//	voter ID contains the ID of a voter as an int.
	private String voter_ID;
//	vovterName contains the full name of the voter
	public String voterName;
	public int age;
//	voter info contains other information of the voter which could include registration status.
	public String voterInfo;
	public boolean hasVoted;
//	public String voterPassword;
	

	
	public Voter(){
		
	}
	
	public Voter(String voteID, String voteName, int vAge,String voteInfo,boolean hasVoted ){
		voter_ID = voteID;
		voterName = voteName;
		age = vAge;
		voterInfo = voteInfo;
		hasVoted = false;
//		voterPassword = votePass;
		
	}
	
//	Purpose: get the voter ID 
//	Preconditions: none
//	Postconditions: return voter ID
	public String getVoterID() {
		return voter_ID;
	}

//	Purpose: set the voter ID
//	Preconditions: none
//	Postconditions: updates the voter ID
	public void setVoterID(String voter_ID) {
		this.voter_ID = voter_ID;
	}
	
	public void setVoterName( String name){
		this.voterName = name;
	}
	
	public String getVoterName(){
		return voterName;
		
	}
	public void setHasVoted( boolean voted){
		this.hasVoted = voted;
	}
	public boolean getHasVoted(){
//		System.out.println("has voted " + hasVoted);
		return hasVoted;
	}
	
	public void setAge( int vAge){
		this.age = vAge;
	}
	
	public int getAge(){
		return age;
	}
	public void setVoterSS(String info){
		this.voterInfo = info;
	}
	public String getVoterSS(){
		return voterInfo;
	}
//	public void setVoterPassword(String pass){
//		this.voterPassword = pass;
//	}
//	
//	public String getVoterPass(){
//		return voterPassword;
//	}
	
//	Purpose:logs the user in uses approve login
//	Preconditions: use login information for the voter
//	Postconditions: use is logged in
	public void login(){
		
		
	}
//	Purpose:select a candidate 
//	Preconditions: none
//	Postconditions: marks candidate as selected and saved for review later
	public void selectCandidate(){
		
	}
	
//	Purpose: confirm selected candidates 
//	Preconditions: none
//	Postconditions: votes are sent to the voter handler once confirmed
	public void castVote(){
		
	}
	
}

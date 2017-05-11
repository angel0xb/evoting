
public class candidate {
//	contains the ID of the candidate as an int
	private int candidateID = 00000000 ;
//	contains the candidates full name as a string 
	public  String candidateName = "";
//	contains the candidates party as a string 
	public  String candidateParty = "";
//	contains the amount of current votes the candidate has 
	private int votes = 0 ;
	public candidate(){
		
	}

	public candidate( int candID, String canName,String canParty,int  v){
//		candidateID = candID;
		setCandidateID(candID);
		candidateName = canName;
		candidateParty = canParty;
		votes = v;
		
		
	}
	
	public void setCandName(String name){
		this.candidateName = name;
	}

//	gets candidates names
	public String getCandName(){
		return candidateName;
	}
//	gets the candidates ID
	public int getCandidateID() {
		return candidateID;
	}
//	sets the candidates ID
	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}
	
	public void setParty(String candParty){
		this.candidateParty = candParty;
	}
//gets the votes of the candidate
	public int getVotes() {
		return votes;
	}
//	sets the amount of votes the candidate has

	public void setVotes(int v) {
		this.votes = v;
	}
	
	public void addVote(){
		votes = votes + 1;
		
	}
	public String getCandidateParty() {
		return candidateParty;
	}
	
	public void printCand(){
		System.out.println("Candidate: " + this.getCandName());
		System.out.println("Candidate Party: " + this.getCandidateParty());
		System.out.println("Votes: " + this.getVotes());
	}

	
	

}

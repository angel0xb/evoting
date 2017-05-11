# evoting
README
E-Voting System 
College of Charelstion
CSCI 360
Prof X.

This program can run from either the votingUI class, electionOfficer class or the votingDriver class. For the most part it is meant to begin in the votingDriver class.
This class only makes the call to the votingUI and contructs the window using createAndShowGUI the two parameters is which window is on and which is off. The two windows it contains is the login and the voting frames.

All voters must be preregistered at this time.

Starting with the login the voter must input their voterID and their social these are simplified(shorter) for testing purposes. Included in submission there will be a copy of all register voter information without encryption for you to test out (original SS). After unsuccessfully making encryption methods and decryption methods(using cryoto these are in database class work out outside of swing) the decision to move over to one hash encryption. So all socials are encrypted prior and input is encrypted at time of input to match these so use original inputs !
(original SS) 

once entered a quick check to make sure you entered the right information a pop up box is given to confirm yes to continue no to try login in again.  At this point there is no attempt limit due to timing issues.

After confirmation you will be given candidates check a box to make selection if none is selected then NONE candidate is given the vote. NONE is an option for those who do not want to vote for any candidate. 

0nce you make a selection press submit here you are prompted again to make sure you have chosen the right selection. Selecting no will take you back to the selection frame yes will take you back to login change voter information to say they have voted and add a vote to candidate selected.

If you type in invalid input, information that is not for a registered then you are given wrong credential window press x and try again. Similarally if you try voted and you have already voted  a window will pop up stating you have already voted and exit the program. If you would like the window to not exit the program comment out Line409. 

To get to the election officer login you will type in the election officer login in the voter login this is the same for all election officers. The Voter ID input is ZX11 and the social input is 777. Here you are given another login page for the election officer (super secure) which works the same as the voter but you also have the option to return to the voter login by pressing voter login button.

If you successfully login you are given three button options Log Out , View Results, and View Percentage. The Logout button does what you expect to takes you back to the Election Officer login window. View Results take you to a screen that shows displays all the candidates their party and the amount of current votes. At the bottom of this window there is a return button that take you back to the options page. The view percentage window shows the amount of registered voters, the amount voted, and the voting percentage; this is used for recounting purposes. This window has a similar return button.

There were testing classes for the project without swing but we have gotten rid of these when implementing swing since they did not apply. Testing here was done manually in swing and print statements.

https://www.mkyong.com/java/java-md5-hashing-example/
Was used to help with encryption look at MD5HashingExample.

Future we would like to add better documentation & clean up, a limit to three attempted logins, encryption & decryption and the use of a database. 


Running 
Run the votingDriver class
For Voting:
For voter ID type in A0 and 9999 for social. Or look though original voter information.
Then navigate through following windows.

For Election Officer login 
For voter ID type in ZX11 and 7777 for social.
For Officer ID type in 1 and p for password. Or look through original Officer information.
Then navigate through following windows.







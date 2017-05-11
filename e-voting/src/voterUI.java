import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.mkyong.test.MD5HashingExample;
import com.sun.xml.internal.ws.api.Component;

import java.awt.event.ActionListener;

//Task: provides an interface for the voter
//Input: Takes information provided from the voter to display
//Output: GUI or pages


public class voterUI extends JPanel{
	JLabel label;
    JFrame frame;
    String simpleDialogDesc = "The candidates";
  
    
//    voteController controller = new voteController();
//    Voter v 
 
	
    public static void main(String[] args) throws NoSuchAlgorithmException {
    	
 
		
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
                try {
					createAndShowGUI(true,false);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    public voterUI(){
    	
    }
	public voterUI(JFrame frame ) throws FileNotFoundException{
		
		
		super(new BorderLayout());
		
		
//		System.out.println("Voter after voterUI contructor " + this.getVoterID());
		this.frame = frame;
        JLabel title;
        
        //Create the components.
        JPanel choicePanel = createCheckBoxes();
        
//        System.out.println("passed createSimpleDialogBox");
                
        title = new JLabel("Click the \"Vote\" button"
                           + " once you have selected a candidate.",
                           JLabel.CENTER);
        
        label = new JLabel("Vote now!", JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        choicePanel.setBorder(BorderFactory.createEmptyBorder(20,20,5,20));

        //Lay out the main panel.
        add(title, BorderLayout.NORTH);  
        add(label, BorderLayout.SOUTH);        
        add(choicePanel, BorderLayout.CENTER);
    }
	public void voteDisplay(){
		
	}



	void setLabel(String newText) {
        label.setText(newText);
    }
	
//	change to have input of string for the file read
//	create a file for each page of candidates
	public JPanel createCheckBoxes() throws FileNotFoundException{
		String simpleDialogDesc = "The candidates";
		
//		group for checkboxes 
		final ButtonGroup group = new ButtonGroup();
		
		final int candidates = 5;
		
//		create an array of checkboxes
		final JCheckBox[] checkboxes = new JCheckBox[candidates];
		
//		read the candidate txt file
		File resultsFile = new File("candidate.txt");
		Scanner resultsScanner = new Scanner(resultsFile);

		int i =0;
//		read through all the lines
		while(resultsScanner.hasNextLine()){
			
			String nextLine = resultsScanner.nextLine();
//			split line and obtain necessary data
			String[] splitLine = nextLine.split(",");
			String candidate = splitLine[1];
			String party = splitLine[2];
			
//			populate checkboxes with data
			checkboxes[i] = new JCheckBox("<html>Candidate "+i+": "+ candidate + " of the " + party + " party." + "</html>");
			group.add(checkboxes[i]);
			
			i++;	
	
		}

//		subit button
        JButton voteButton = new JButton("Submit");
        voteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		for(int i =0;i<checkboxes.length;i++){
//        		implment switch case?

//        		database db = new database();
        		
        		
//        		try {
//					db.voted(voterID);
//				} catch (IOException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
        		final JFrame topFrame = (JFrame) SwingUtilities.getRoot(frame);
        		areYouSure(checkboxes);
        		topFrame.setVisible(false);
//        		voteController.voted()
//        		v.setHasVoted(true);
//        		v = new Voter();
//        		System.out.println("after sumbit " + this.getVoterID());
//        		voteController vc = new voteController(v);
        		
//        		checks to see which checkbox is selected
//        		adds vote accordingly
//        			if(checkboxes[0].isSelected())
//        			{
//        				try {
//							db.addVote("A0");
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//        			}
//        			else if(checkboxes[1].isSelected()){
//        				try {
//							db.addVote("A1");
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//        			}
//        			else if(checkboxes[2].isSelected()){
//        				try {
//							db.addVote("A2");
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//        			}
//        			
//        			else if(checkboxes[3].isSelected()){
//        				try {
//							db.addVote("A3");
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//        			} else
//						try {
//							db.addVote("A4");
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//        			topFrame.setVisible(false);
////        			restart logging process
//        			try {
//        				
////        				System.out.println("Voter before creat e& show " + v.getVoterID());
//						createAndShowGUI(true,false);
////						System.out.println("Voter after creat e& show " + v.getVoterID());
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
        	}
        	
        });
        
        

        return createPane(simpleDialogDesc + ":",
                          checkboxes, 
                          voteButton);
		
		
	}
	
	 private JPanel createPane(String description,
             JCheckBox[] checkboxes,
             JButton showButton) {
			int numChoices = checkboxes.length;
			JPanel box = new JPanel();
			JLabel label = new JLabel(description);
			
			box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
			box.add(label);
			
			for (int i = 0; i < numChoices; i++) {
			box.add(checkboxes[i]);
			}
			
			
			JPanel pane = new JPanel(new BorderLayout());
			pane.add(box, BorderLayout.NORTH);
			pane.add(showButton, BorderLayout.SOUTH);
//			System.out.println("returning pane");
			return pane;
		}
	 
	 
	    public static void createAndShowGUI( boolean f1,boolean f2) throws FileNotFoundException {
	        //Make sure we have nice window decorations.
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        JDialog.setDefaultLookAndFeelDecorated(true);
	        
	        
//	        ************************************************************************************************************
//	    	creates login window
	    	JFrame frame1 = new JFrame("Voter Login");
			frame1.setSize(480, 300);
//			Access to toolkit that has helpful methods
			Toolkit tk = Toolkit.getDefaultToolkit();
			
//			dimentison class to get the dimension of the screen tk grabs the screensize
			Dimension dim = tk.getScreenSize();
//			get the x and y pos for centering
			final int xPos = (dim.width /2) - (frame1.getWidth() /2); 
			final int yPos = (dim.height /2) - (frame1.getHeight() /2); 
			frame1.setLocation(xPos, yPos);
			
//			close window on x click
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			frame1.add(panel);
			
			voterUI vUI = new voterUI(frame1);
//			System.out.println("Voter after creat e& show " + v.getVoterID());
			vUI.login(panel);

			frame1.setVisible(f1);
			boolean ok = f2;
////			 ***********************************************************************************************************
	        //Create and set up the window.
	        JFrame frame = new JFrame("Vote");
	        frame.setSize(480, 300);
//	        center the window
	        frame.setLocation(xPos, yPos);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	        //Set up the content pane.
	        Container contentPane = frame.getContentPane();
	        contentPane.setLayout(new GridLayout(1,1));
	        contentPane.add(new voterUI(frame));
//	        System.out.println("after adding to content pane" + v.getVoterID());

	        //Display the window.
	        frame.pack();
	        frame.setVisible(f2);
//	
	    }
////		 ***************************************************************************************************************

	    private void login(final JPanel panel) {
	    	
	    	
//	    gets the parent Frame 
	        final JFrame topFrame = (JFrame) SwingUtilities.getRoot(panel);

			panel.setLayout(null);
			
//			System.out.println(BorderLayout.CENTER);
//			int center = Integer.parseInt(BorderLayout.CENTER);
			JLabel voterLabel = new JLabel("Voter ID: ");
			voterLabel.setBounds(130, 80, 80, 25);
			panel.add(voterLabel,BorderLayout.CENTER);

			final JTextField voterText = new JTextField(20);
			voterText.setBounds(200, 80, 160, 25);
			panel.add(voterText,BorderLayout.CENTER);

			JLabel socialLabel = new JLabel("Social: ");
			socialLabel.setBounds(130, 140, 80, 25);
			panel.add(socialLabel);

			final JPasswordField socialText = new JPasswordField(20);
			socialText.setBounds(200, 140, 160, 25);
			panel.add(socialText);

			JButton loginButton = new JButton("Login");
			loginButton.setBounds(360, 220, 80, 25);
			 
			loginButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		voteController controller = new voteController();
//	        		System.out.println("Voter on login click  " + v.getVoterID());
	        		
	        		String voterID = voterText.getText();
	        		System.out.println("ID " + voterID);
	        		 Voter v = controller.readVoter(voterID);
//	        		 votedAfterLogin = voterID;
//	        		 System.out.println( "votedAfterLogin" + votedAfterLogin);
//	        		 votedAfterLogin = v.getVoterID();
//	        		 System.out.println("Voter after read voter call " + v.getVoterID());
	        		String social = String.valueOf(socialText.getPassword()) ;
	        		
	        		System.out.println("Social " + social);
					try {
						String newSocial = MD5HashingExample.convert(social);
						social = newSocial;
						System.out.println("new social " + newSocial);
					} catch (NoSuchAlgorithmException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println("NEWW Socials " + social); 
//	        		Check to see if the voter exists.
//	        		|| v.getVoterSS() == null || !voterID.equals(v.getVoterID()) || !social.equals(v.getVoterSS())
	        		if(v.getVoterID()==null ){ 		    				
	        			try {
//   					 createAndShowGUI(true,false);
						wrongCreds();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
//		    		if the voter exists do this
		    		if(v.getVoterID()!= null){
		    			System.out.println("Voter when voter ID is not null " + v.getVoterID());
//		    			prints out the SS for the voter ID entered so no need to remember the SS for testing.
		    			 System.out.println("*HINT* SS = " + v.getVoterSS().trim());
		    			
						
//		    			 System.out.println("scoial " + social);

		    			 if( social.trim().equals(v.getVoterSS().trim()) && v.getHasVoted() == false){
		    				 if(v.getVoterID().equals("ZX11") && v.getVoterSS().equals("d79c8788088c2193f0244d8f1f36d2db")){
		    					 
		    					 topFrame.setVisible(false);
		    					 try {
									eOfficerUI.createAndShowOffUI(true,false,false,false);
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		    				 }
		    				 else{
		    				 
		    				 System.out.println(" here");
		    				 thisYou(v);
		    				 
		    				 topFrame.setVisible(false);
		    				 }
		    				 }
					
		    			 
		    			 else if(v.getHasVoted() == true){
		    				 System.out.println("if has voted is true (login) " + v.getVoterID());
			    				 try {
			    				topFrame.setVisible(false);
								alreadyVoted();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								}
			    			}
		    			 else{
//		    				 System.out.println("Voter " + v.getVoterID());
		    				 
		    				 try {
							wrongCreds();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    				 }
		    			 
		    		
		    			 
//		    	return v;
		    	System.out.println("voter has " + v.getHasVoted() );
		    		}
//		    		return v;
		    		
			    	System.out.println("voter has " + v.getHasVoted() );
	        	}

	        	
	        });
//			System.out.println("voter has " + v.getHasVoted() );
			panel.add(loginButton);
//			return v;
			
		
		}

	    public JFrame areYouSure(final JCheckBox[] checkboxes){

	    	JFrame frame1 = new JFrame("You Sure?");
	    	final JFrame topFrame = (JFrame) SwingUtilities.getRoot(frame1);
	    	frame1.setSize(480, 300);
			JPanel panel = new JPanel();
			
			panel.setLayout(null);
//			Access to toolkit that has helpful methods
			Toolkit tk = Toolkit.getDefaultToolkit();
			
//			dimentison class to get the dimension of the screen tk grabs the screensize
			Dimension dim = tk.getScreenSize();
//			get the x and y pos for centering
			final int xPos = (dim.width /2) - (frame1.getWidth() /2); 
			final int yPos = (dim.height /2) - (frame1.getHeight() /2); 
			frame1.setLocation(xPos, yPos);
			
//			close window on x click
			
//			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLabel text = new JLabel("Sure you want to submit?" );
			text.setBounds(120, 70, 160, 25);
			panel.add(text);
			
			
			JButton no = new JButton("no");
			no.setBounds(180,120, 80,25);
			no.addActionListener(new ActionListener(){


				public void actionPerformed(ActionEvent e) {
					topFrame.setVisible(false);
					try {
						createAndShowGUI(false,true);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			});
			
			JButton yes = new JButton("yes");
			yes.setBounds(180,160, 80,25);
			yes.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					topFrame.setVisible(false);
					database db = new database();
					if(checkboxes[0].isSelected())
        			{
						System.out.println("first is checked");
        				try {
							db.addVote("A0");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        			else if(checkboxes[1].isSelected()){
        				try {
							db.addVote("A1");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        			else if(checkboxes[2].isSelected()){
        				try {
							db.addVote("A2");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        			
        			else if(checkboxes[3].isSelected()){
        				try {
							db.addVote("A3");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			} else
						try {
							db.addVote("A4");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			topFrame.setVisible(false);
//        			restart logging process
        			try {
        				
//        				System.out.println("Voter before creat e& show " + v.getVoterID());
						createAndShowGUI(true,false);
//						System.out.println("Voter after creat e& show " + v.getVoterID());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				
			});
			panel.add(no);
			panel.add(yes);
			frame1.add(panel);
			frame1.setVisible(true);
	return frame1;
	    }
	    
	    public JFrame thisYou(final Voter voter){
	    	
	    	
	    	JFrame frame1 = new JFrame("Is This You?");
	    	final JFrame topFrame = (JFrame) SwingUtilities.getRoot(frame1);
	    	frame1.setSize(480, 300);
			JPanel panel = new JPanel();
			panel.setLayout(null);
//			Access to toolkit that has helpful methods
			Toolkit tk = Toolkit.getDefaultToolkit();
			
//			dimentison class to get the dimension of the screen tk grabs the screensize
			Dimension dim = tk.getScreenSize();
//			get the x and y pos for centering
			final int xPos = (dim.width /2) - (frame1.getWidth() /2); 
			final int yPos = (dim.height /2) - (frame1.getHeight() /2); 
			frame1.setLocation(xPos, yPos);
			
//			close window on x click
			
//			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLabel text = new JLabel("Are you " + voter.getVoterName() + "?" );
			text.setBounds(170, 70, 160, 25);
			panel.add(text);
			
			
			JButton no = new JButton("no");
			no.setBounds(180,120, 80,25);
			no.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					try {
						topFrame.setVisible(false);
						createAndShowGUI(true,false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
				}
				
			});
			
			JButton yes = new JButton("yes");
			yes.setBounds(180,160, 80,25);
			yes.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					topFrame.setVisible(false);
					database db = new database();
   				 try {
						createAndShowGUI(false,true);

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
   				 System.out.println("Logging in");
//   				 VVID = voter.getVoterID();
   				 try {
						db.voted(voter.getVoterID());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//   				 System.out.println("Voter after loggin " + v.getVoterID());
   				 
				}
				
			});
			panel.add(no);
			panel.add(yes);
			frame1.add(panel);
			frame1.setVisible(true);
			return frame1;
	    	
	    }
	
	public JFrame alreadyVoted() throws FileNotFoundException{
    	JFrame frame1 = new JFrame("Already Voted");
		frame1.setSize(240, 150);
		JPanel panel = new JPanel();
		panel.setLayout(null);
//		Access to toolkit that has helpful methods
		Toolkit tk = Toolkit.getDefaultToolkit();
		
//		dimentison class to get the dimension of the screen tk grabs the screensize
		Dimension dim = tk.getScreenSize();
//		get the x and y pos for centering
		final int xPos = (dim.width /2) - (frame1.getWidth() /2); 
		final int yPos = (dim.height /2) - (frame1.getHeight() /2); 
		frame1.setLocation(xPos, yPos);
		
//		close window on x click
//		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel text = new JLabel("You've already voted! ");
		text.setBounds(10, 10, 160, 25);
		
		JLabel text2 = new JLabel(" System Exiting...");
		text2.setBounds(10,50,160,35);
		
		panel.add(text2);
		panel.add(text);
		
		frame1.add(panel);
		
//		createAndShowGUI(false,false);
		frame1.setVisible(true);
		
		return frame1;
	}
	

	public JFrame wrongCreds() throws FileNotFoundException{
    	JFrame frame1 = new JFrame("Wrong Credetnials");
		frame1.setSize(480, 300);
		JPanel panel = new JPanel();
		panel.setLayout(null);
//		Access to toolkit that has helpful methods
		Toolkit tk = Toolkit.getDefaultToolkit();
		
//		dimentison class to get the dimension of the screen tk grabs the screensize
		Dimension dim = tk.getScreenSize();
//		get the x and y pos for centering
		final int xPos = (dim.width /2) - (frame1.getWidth() /2); 
		final int yPos = (dim.height /2) - (frame1.getHeight() /2); 
		frame1.setLocation(xPos, yPos);
		
//		close window on x click
//		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel text = new JLabel("Wrong Credenitals Try Again");
		text.setBounds(150, 100, 260, 25);
		
		panel.add(text,BorderLayout.CENTER);
		
		frame1.add(panel);
		
//		createAndShowGUI(false,false);
		frame1.setVisible(true);
		
		return frame1;
	}
}

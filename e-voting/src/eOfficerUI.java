import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.mkyong.test.MD5HashingExample;


public class eOfficerUI extends JPanel {
	JLabel label;
    JFrame frame;
    String simpleDialogDesc = "Results";
    
    
    public static void main(String[] args) {
		
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
                try {
					createAndShowOffUI(true,false,false,false);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
    
//    
	public eOfficerUI(JFrame frame) throws FileNotFoundException{
		super(new BorderLayout());
		
		
		this.frame = frame;
//        JLabel title;
        
        //Create the components.
        JPanel choicePanel = showResults();
        
//		label at the below retun button
        label = new JLabel("prev page", JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        choicePanel.setBorder(BorderFactory.createEmptyBorder(20,20,5,20));

//      add the label to the panel
        add(label, BorderLayout.SOUTH);        
        add(choicePanel, BorderLayout.CENTER);
    }
    void setLabel(String newText) {
        label.setText(newText);
    }
    
    
//    creates the result window
//    *****READS CANDIDATE TXT FILE****
    public JPanel showResults() throws FileNotFoundException{
    	String simpleDialogDesc = "Voting Results";
    	File resultsFile = new File("candidate.txt");
		Scanner resultsScanner = new Scanner(resultsFile);
//		creates the new return button
        JButton returnButton = new JButton("return");
		JTextArea candRes = new JTextArea(5,15);
//	background to match the grey color of the window	
		candRes.setBackground(new Color(238, 238, 238));

//		read through all the lines
		while(resultsScanner.hasNextLine()){
			String nextLine = resultsScanner.nextLine();
//			get each data separated by comma 
			String[] splitLine = nextLine.split(",");
//			store data in variable
			String candidate = splitLine[1];
			String party = splitLine[2];
			String v = splitLine[3];
			String votes = v.substring(0, v.length() - 1);

//			print out statment with the information for each candidate
			candRes.append("Cadidate " + candidate + " of the " + party +" party " +" has " + votes + " votes. \n");
			
		}	

	        return createEPane(simpleDialogDesc ,
	                          candRes, 
	                          returnButton);
    }
    
    
    
	 private JPanel createEPane(String description,
             JTextArea text,
             JButton showButton) {
		 final JFrame topFrame = (JFrame) SwingUtilities.getRoot(frame);
			JPanel box = new JPanel();
			box.setLayout(null);
			JLabel label = new JLabel(description);
			label.setBounds(50,50,50,50);
			
			box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
			box.add(label);
			
		
			box.add(text);
			
			
			JPanel pane = new JPanel(new BorderLayout());
			pane.add(box, BorderLayout.NORTH);
			pane.add(showButton, BorderLayout.SOUTH);
			showButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					topFrame.setVisible(false);
					try {
						createAndShowOffUI(false,false,true,false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			});

			return pane;
		}
	 
//	 election officer login page, results page, officer options, 
	 static void createAndShowOffUI( boolean f1,boolean f2,boolean f3, boolean f4) throws FileNotFoundException {
	        //Make sure we have nice window decorations.
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        JDialog.setDefaultLookAndFeelDecorated(true);
	        
	        
//	        ************************************************************************************************************
//	    	creates election officer login window
	    	JFrame eFrame1 = new JFrame("Election Officer Login");
			eFrame1.setSize(480, 300);
//			Access to toolkit that has helpful methods
			Toolkit tk = Toolkit.getDefaultToolkit();
			
//			dimentison class to get the dimension of the screen tk grabs the screensize
			Dimension dim = tk.getScreenSize();
//			get the x and y pos for centering
			final int xPos = (dim.width /2) - (eFrame1.getWidth() /2); 
			final int yPos = (dim.height /2) - (eFrame1.getHeight() /2); 
			eFrame1.setLocation(xPos, yPos);
			
//			close window on x click
			eFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			eFrame1.add(panel);
			
			eOfficerUI e = new eOfficerUI(eFrame1);
//			v.login(panel);
			e.offLogin(panel);

			eFrame1.setVisible(f1);
//			 ***********************************************************************************************************
			
//			sets up the Results page 
	        //Create and set up the window.
	        JFrame frame = new JFrame("Results");
	        frame.setSize(480, 300);
//	        center the window
	        frame.setLocation(xPos, yPos);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	        //Set up the content pane.
	        Container contentPane = frame.getContentPane();
	        contentPane.setLayout(new GridLayout(1,1));
	        contentPane.add(new eOfficerUI(frame));

	        //Display the window.
	        
	        frame.setVisible(f2);
//			 ***************************************************************************************************************
//	        Creates the Options page for the officer
	        //Create and set up the window.
	        JFrame frame2 = new JFrame("Officer Options");
	        frame2.setSize(480, 300);
//	        center the window
	        frame2.setLocation(xPos, yPos);
	        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        
	        JPanel panel2 = new JPanel();
			frame2.add(panel2);
			
			eOfficerUI el = new eOfficerUI(frame2);
			
			el.offOptions(panel2);

			frame2.setVisible(f3);
//			 ***********************************************************************************************************
//			create the voter percentage page
	        //Create and set up the window.
	        JFrame frame3 = new JFrame("Percent Voted");
	        frame3.setSize(480, 300);
//	        center the window
	        frame3.setLocation(xPos, yPos);
	        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        
	        JPanel panel3 = new JPanel();
	       
			frame3.add(panel3);
			
			eOfficerUI el2 = new eOfficerUI(frame3);
			el2.offPercentage(panel3);

			frame3.setVisible(f4);


	
	    }
	 private void offOptions(final JPanel panel){
		 final JFrame topFrame = (JFrame) SwingUtilities.getRoot(panel);
		 panel.setLayout(null);
			JLabel title = new JLabel("Select an option:",JLabel.CENTER);
			title.setBounds(130, 80, 180, 25);
			panel.add(title,BorderLayout.CENTER);
			
			JButton logoutButton = new JButton("Log Out");
			logoutButton.setBounds(170, 220, 120, 25);
			logoutButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					topFrame.setVisible(false);
					try {
						createAndShowOffUI(true,false,false,false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			});
			panel.add(logoutButton);
			
			JButton resButton = new JButton("View Results");
			resButton.setBounds(90, 120, 120, 25);
			resButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					topFrame.setVisible(false);
					try {
						createAndShowOffUI(false,true,false,false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			});
			panel.add(resButton);
			
			
			JButton percentButton = new JButton("View Percentage");
			percentButton.setBounds(280, 120, 130, 25);
			percentButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					topFrame.setVisible(false);
					try {
						createAndShowOffUI(false,false,false,true);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			});
			panel.add(percentButton);
	        

		
		 
	 }
	 
	 
	 private void offPercentage(JPanel panel) throws FileNotFoundException{
		 
		 final JFrame topFrame = (JFrame) SwingUtilities.getRoot(panel);
		 
		 panel.setLayout(null);
		 
	     electionOfficeHandler eO = new electionOfficeHandler();
		 String votingPer = eO.votingPercentage();
	     System.out.println("V p " + votingPer);
	     JTextArea percent = new JTextArea(votingPer);
	     percent.setBackground(new Color(238, 238, 238));
	     percent.setBounds(130, 80, 180, 125);
	     panel.add(percent);
	     
		 JButton returnButton= new JButton("Return");
			returnButton.setBounds(170, 220, 120, 25);
//		 returnButton.setBounds(90, 120, 120, 25);
		 
		 returnButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 topFrame.setVisible(false);
					try {
						createAndShowOffUI(false,false,true,false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			 
		 });
		 panel.add(returnButton);
	
	 }
	 

//	 set up the officer login window
	    private void offLogin(final JPanel panel) {
	        final JFrame topFrame = (JFrame) SwingUtilities.getRoot(panel);

				panel.setLayout(null);
				
				System.out.println(BorderLayout.CENTER);
				
//				label for officer id
				JLabel offLabel = new JLabel("Officer ID: ");
				offLabel.setBounds(130, 80, 80, 25);
				panel.add(offLabel,BorderLayout.CENTER);
				
//				text input for the officer id
				final JTextField offText = new JTextField(20);
				offText.setBounds(200, 80, 160, 25);
				panel.add(offText,BorderLayout.CENTER);

//				password label
				JLabel pwLabel = new JLabel("Password: ");
				pwLabel.setBounds(130, 140, 80, 25);
				panel.add(pwLabel);

//				input field for the password 
				final JPasswordField pwText = new JPasswordField(20);
				pwText.setBounds(200, 140, 160, 25);
				panel.add(pwText);
				
//				voter button
				JButton voterButton = new JButton("Voter");
				voterButton.setBounds(60, 220, 80, 25);
				voterButton.addActionListener(new ActionListener(){

//					if the button is clicked then hide the top frame and show the voter login window
					public void actionPerformed(ActionEvent e) {
						 topFrame.setVisible(false);
						try {
							voterUI.createAndShowGUI(true, false);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				});
				panel.add(voterButton);
				
//				create login buttton
				JButton loginButton = new JButton("Login");
				loginButton.setBounds(360, 220, 80, 25);
				
				
				loginButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						electionOfficeHandler offHandler = new electionOfficeHandler();

						//officer ID from text box input						
						String officerID = offText.getText();
						 electionOfficer officer = offHandler.readOfficer(officerID);
						 
						 
//						the officer is not found display the invalid input
				    	 if(officer.getName() == null ){
				    	
				    		 invalidInput();
				    	 }
				    	 
//				    	The officer is found 
				    	 if(officer.getID() !=null){
//				    	save the real password associated with officer id	 
				    	 String realpass = officer.getPass().trim();
//				    	 gets the password from the password input box
				    	 String pw =  String.valueOf(pwText.getPassword()) ;
//				    	 console print outs for testing 
				    	 System.out.println("input pass" + pw);
				    	 System.out.println("(for testing purposes) Password should be: " + realpass);
				    	 
				    	 
//				    	 the password is found and converted to encrypted form
				    	 try {
							String hashPass = MD5HashingExample.convert(pw);
							System.out.println("hash pass " + hashPass);
							pw = hashPass;
						} catch (NoSuchAlgorithmException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
				    	 
				    	 System.out.println("new pass " + pw);
//				    	 if the encrypted pass matches the pass in the database
//				    	 display the officer login page
				    	 if(pw.equals(officer.getPass().trim())){
				 
				    		 topFrame.setVisible(false);
				    		 try {
				    			 
								createAndShowOffUI(false,false,true,false);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				    	 }
//				    	 if password does not match display invalid input login window
				    	 else{invalidInput();}
				    	 
					}	 
				    	 
					}
					
				});
				
				panel.add(loginButton);
				
				
	    }
	    
//	    pop up window is displayed for invalid input
	    public JFrame invalidInput(){
	    	JPanel panel = new JPanel();
			panel.setLayout(null);
//	    	panel.setLayout(null);
	    	JFrame frame = new JFrame("Invalid");
	        frame.setSize(280, 150);
//	        center the window
//			Access to toolkit that has helpful methods
			Toolkit tk = Toolkit.getDefaultToolkit();
			
//			dimentison class to get the dimension of the screen tk grabs the screensize
			Dimension dim = tk.getScreenSize();
//			get the x and y pos for centering
			final int xPos = (dim.width /2) - (frame.getWidth() /2); 
			final int yPos = (dim.height /2) - (frame.getHeight() /2);
	        frame.setLocation(xPos, yPos);
	        
	    	
	    	JLabel invalidLabel = new JLabel("Invalid Credentials please try again");
	    	invalidLabel.setBounds(20, 60, 230, 20);
	    	panel.add(invalidLabel);
	    	frame.add(panel);
	    	frame.setVisible(true);
			return frame;
	    	
	    }
	 

}

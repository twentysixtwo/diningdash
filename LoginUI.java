import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;

/**
 * The LoginUI class displays the login window which shows up at every terminal when no one is logged in to that terminal.
 * From the login window any one of the five types of employee accounts can be accessed. The login window lets a user
 * enter their name and password, and then brings up the correct type of employee screen.
 * 
 * @author Kalev Roomann-Kurrik
 */

public class LoginUI extends JPanel{
	
	JTextField nameField;

	JTextField passwordField;
	
	/** 
	 * This is the constructor for the LoginUI class. It generates the actual login window, sets up all of the buttons and
	 * display boxes, and also has a listener for when a user clicks on the login button. Once this happens the
	 * loginButtonClicked() method is called.
	 */
	public LoginUI(){
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5,5,5,5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.weightx = 1.0;
		gbc.ipady = 30;
		
		JLabel title = new JLabel("Dining Dash");
		title.setFont(new Font("Arial",Font.BOLD,16));
		
		add(title,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.0;
		gbc.ipady = 0;
		
		JLabel username = new JLabel("User name: ");
		
		add(username,gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		nameField = new JTextField(20);
		
		add(nameField,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		
		JLabel password = new JLabel("Password: ");
		
		add(password,gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		passwordField = new JTextField(20);
		
		add(passwordField,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipady = 5;
		gbc.ipadx = 20;
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 1.0;
		
		JButton loginButton = new JButton("Login");
		
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Login button clicked");
				loginButtonClicked();
			}
		});
		
		add(loginButton,gbc);
			
	}
	
	/**
	 * The loginButtonClicked method is called inside the actionListener for the login button that is part of the login
	 * window. This method checks the strings for the username and password in the login window and compares them to a
	 * list of employee usernames and passwords from the restaurant database in the Records subsystem. If a valid
	 * employee is found then the type of employee is used to call the constructor of the correct UI class and open up
	 * the window for that employee.
	 * 
	 * If either textfield is blank (username or password) then nothing will happen.
	 * 
	 * If either the username or password is incorrect nothing will happen.
	 */
	public void loginButtonClicked(){
		System.out.println("Username: "+nameField.getText());
		System.out.println("Password: "+passwordField.getText());
		
		if(nameField.getText().equals("Kalev"))
		{
			System.out.println("Hello Kalev");
			
			if(passwordField.getText().equals("openseasame"))
			{
				System.out.println("Password verified");
				
				BusboyUI busboyWindow = new BusboyUI(this,nameField.getText());
				
				nameField.setText("");
				passwordField.setText("");
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame main = new JFrame("Login");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(600,200);
		//main.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		main.setLocation(dim.width/2-140,dim.height/2-85);
		
		main.setContentPane(new BusboyUI(new LoginUI(), "Henry"));
		main.pack();
		
		main.setVisible(true);
	}

}

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;

/** 
 * The BusboyUI class displays the busboy window which shows the map of the tables for the restaurant and their respective
 * status. If a table is dirty (red) then the busboy can click on it after they have cleaned it to change the status to
 * unoccupied (green). The status is updated for all of the employees working on the floor, and the host can see that the
 * table is ready to be seated.
 * 
 * @author Kalev Roomann-Kurrik
 */
public class BusboyUI extends JFrame{

	/**
	 * Reference to the login screen that opened this BusBoyUI
	 */
	LoginUI opener;
	
	JPanel gridPanel;
	
	JButton selectedButton;
	
	int x;
	int y;
	
	int MAX_ROWS;
	int MAX_COLUMNS;
	
	int tableNumber;
	
	String busboyName;
	
	/**
	 * This is the constructor for the BusboyUI class and is called whenever a new busboy window is needed. It generates the
	 * window, and displays the up to date map of the restaurant, including the status of every table.
	 */
	public BusboyUI(LoginUI loginWindow,String name){
		super("Busboy");
		
		opener = loginWindow;
		
		opener.setVisible(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		busboyName = new String("Busboy "+name);
		
		MAX_ROWS = 3;
		MAX_COLUMNS = 3;
		
		gridPanel = new JPanel(new GridLayout(MAX_ROWS,MAX_COLUMNS));
		
		JButton tableButton;
		tableNumber = 1;
			
		for(y=0;y<MAX_ROWS;y++)
		{
			for(x=0;x<MAX_COLUMNS;x++)
			{
				tableButton = new JButton(((Integer)tableNumber).toString());
				tableButton.setBackground(Color.red);
				
				tableButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						selectedButton = (JButton)e.getSource();
						if(selectedButton.getBackground() != Color.gray)
						{
							tableNumber = Integer.parseInt(selectedButton.getText());
							System.out.println("Table number is "+tableNumber);
						}
					}
				});
				
				tableNumber++;
				
				gridPanel.add(tableButton);
				
			}
		}
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,2,10,10));
		
		JButton logoutButton = new JButton("Logout");
		
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				logout();
			}
		});
		
		JButton clearButton = new JButton("Clear Table");
		
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cleanTable();
				}
		});
		
		buttonPanel.add(clearButton);
		buttonPanel.add(logoutButton);
		
		setSize(256,256);  
		getContentPane().add(gridPanel,BorderLayout.CENTER);
		getContentPane().add(new JLabel(busboyName),BorderLayout.NORTH);
		getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		pack();                                      
		setVisible(true);
	}
	
	/**
	 * This method is called whenever a busboy clicks on a dirty table. The status of the table is first checked in the
	 * actionListener for when a busboy clicks on a table. This method calls a method in the Busboy Account class that
	 * sets the status of the table to unoccupied (green) which is then updated on the map of tables for the restaurant.
	 * 
	 */
	public void cleanTable(){
		selectedButton = (JButton)gridPanel.getComponent(tableNumber-1);
		if(selectedButton.getBackground() == Color.red)
		{
			selectedButton.setBackground(Color.green);
			System.out.println("Table "+tableNumber+" is clean");
		}
	}
	
	/**
	 * This method is called whenever a busboy clicks on the logout button. It will close the BusboyUI window, and bring back
	 * the login window.
	 */
	public void logout(){
		opener.setVisible(true);
		this.dispose();
	}
}

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

/** 
 * This is the UI for the Host accounts
 * 
 * @author Henry Chao
 */
public class HostUI extends JFrame{

	/**
	 * Reference to the login screen that opened this HostUI
	 */
	LoginUI opener;
	
	JPanel gridPanel;
	
	JButton selectedButton;
	
	int x;
	int y;
	
	int MAX_ROWS;
	int MAX_COLUMNS;
	
	int tableNumber;
	LinkedList<Table> tableList;
	DataKeeper dk = new DataKeeper();
	
	JComboBox cb = new JComboBox();
	
	String hostName;
	
	/**
	 * This is the constructor for the BusboyUI class and is called whenever a new busboy window is needed. It generates the
	 * window, and displays the up to date map of the restaurant, including the status of every table.
	 */
	public HostUI(LoginUI loginWindow,String name){
		super("Host");
		
		opener = loginWindow;
		
		opener.setVisible(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		hostName = new String("Host " + name);
		
		// Size of restaurant is determined by the TotalRows and TotalCols field in DataKeeper's restaurantMap
		// To change size, adjust the constructor of Map class
		MAX_ROWS = DataKeeper.restaurantMap.getTotalRows();
		MAX_COLUMNS = DataKeeper.restaurantMap.getTotalCols();
		
		gridPanel = new JPanel(new GridLayout(MAX_ROWS,MAX_COLUMNS));
		
		JButton tableButton;
		tableNumber = 1;
		
		tableList = new DataKeeper().getTables();
		Table t = tableList.pop();
			
		for(y=0;y<MAX_ROWS;y++)
		{
			for(x=0;x<MAX_COLUMNS;x++)
			{
				if( (t.getPosRow() == y) && (t.getPosCol() == x)){
					tableButton = new JButton((t.getTableNumber()).toString());
					tableButton.setBackground(t.getStatus());
					
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
					
					try {t = tableList.pop();}
					catch (Exception e){System.out.println("All tables are added to the map");}
				} //End of if
				else{
					tableButton = new JButton();
					tableButton.setBackground(Color.gray);
				};
				
				tableNumber++;
				
				gridPanel.add(tableButton);
				
			}
		}
		
		JPanel buttonPanel = new JPanel(new GridLayout(2,2,10,10));
		
		String[] waitersAvailable = dk.getListOfWaiters();
		JComboBox waiterList = new JComboBox(waitersAvailable);
		waiterList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb = (JComboBox)e.getSource();
			}
		});
		
		final JRadioButton buttonOne = new JRadioButton("1");
			buttonOne.setSelected(true);
		final JRadioButton buttonTwo = new JRadioButton("2");
		final JRadioButton buttonThree = new JRadioButton("3");
		final JRadioButton buttonFour = new JRadioButton("4");
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(buttonOne);
		bGroup.add(buttonTwo);
		bGroup.add(buttonThree);
		bGroup.add(buttonFour);
		
		JPanel radioPanel = new JPanel(new GridLayout(1,4));
		radioPanel.add(new JLabel("Num seated:"));
		radioPanel.add(buttonOne);
		radioPanel.add(buttonTwo);
		radioPanel.add(buttonThree);
		radioPanel.add(buttonFour);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				logout();
			}
		});
		
		JButton assignButton = new JButton("Assign Table");
		
		assignButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!cb.getSelectedItem().equals("Select Waiter"))
					if(buttonOne.isSelected())
						assignTable((String)cb.getSelectedItem(), 1);
					else if(buttonTwo.isSelected())
						assignTable((String)cb.getSelectedItem(), 2);
					else if(buttonThree.isSelected())
						assignTable((String)cb.getSelectedItem(), 3);
					else if(buttonFour.isSelected())
						assignTable((String)cb.getSelectedItem(), 4);
				}
		});
		
		buttonPanel.add(waiterList);
		buttonPanel.add(radioPanel);
		buttonPanel.add(assignButton);
		buttonPanel.add(logoutButton);
		
		setSize(256,256);  
		getContentPane().add(gridPanel,BorderLayout.CENTER);
		getContentPane().add(new JLabel(hostName),BorderLayout.NORTH);
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
	public void assignTable(String s, int n){
		if(selectedButton.getBackground() == Color.green)
		{
			tableList = new DataKeeper().getTables();
			for(Table t : tableList){
				if((t.getTableNumber() == tableNumber) && (!s.equals("No Waiter Assigned"))){
					selectedButton.setBackground(Color.yellow);
					t.assignedTable(s, n);
				}
			}
			System.out.println("Table " + tableNumber + " is assigned");
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

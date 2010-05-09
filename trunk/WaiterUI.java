import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

/**
 * WaiterUI is the userinterface for the waiter.
 * @author henry
 *
 */

public class WaiterUI extends JFrame{

	/**
	 * Reference to the login screen that opened this WaiterUI
	 */
	LoginUI opener;
	
	JPanel gridPanel;
	
	JButton selectedButton;
	
	int x;
	int y;
	
	int MAX_ROWS;
	int MAX_COLUMNS;
	
	int tableNumber;
	LinkedList<Table> tableList = new DataKeeper().getTables();
	
	String waiterName;
	
	/**
	 * This is the constructor for the BusboyUI class and is called whenever a new busboy window is needed. It generates the
	 * window, and displays the up to date map of the restaurant, including the status of every table.
	 */
	public WaiterUI(LoginUI loginWindow,String name){
		super("Waiter");
		
		opener = loginWindow;
		
		opener.setVisible(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		waiterName = new String("Busboy "+name);
		
		// Size of restaurant is determined by the TotalRows and TotalCols field in DataKeeper's restaurantMap
		// To change size, adjust the constructor of Map class
		MAX_ROWS = DataKeeper.restaurantMap.getTotalRows();
		MAX_COLUMNS = DataKeeper.restaurantMap.getTotalCols();
		
		gridPanel = new JPanel(new GridLayout(MAX_ROWS,MAX_COLUMNS));
		
		JButton tableButton;
		final JLabel tableInfo = new JLabel();
		final JTextArea tableOrder = new JTextArea(20, 25);
		tableOrder.setEditable(false);
		
		tableNumber = 1;
		Table t = tableList.pop();
			
		for(y=0;y<MAX_ROWS;y++)
		{
			for(x=0;x<MAX_COLUMNS;x++)
			{
				if( (t.getPosRow() == y) && (t.getPosCol() == x)){
					tableButton = new JButton((t.getTableNumber()).toString());
					tableButton.setBackground(t.getStatus());
					final int seated = t.getNumSeat();
					final Bill tableBill = t.getTableBill();
					
					tableButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							selectedButton = (JButton)e.getSource();
							if(selectedButton.getBackground() != Color.gray)
							{
								tableNumber = Integer.parseInt(selectedButton.getText());
								System.out.println("Table number is " + tableNumber);
								tableInfo.setText("<html>Table " + tableNumber + "<p>" + 
													"Occupancy: " + seated);
								tableInfo.setMinimumSize(new Dimension(100, 30));
								
								String infoText = new String();
								LinkedList<Order> foodOrders = tableBill.getOrders();
								if(foodOrders == null){
									tableOrder.setText("No orders placed");
								}
								else{
									for(Order o:foodOrders){
										infoText = infoText + o.getFoodName() + '\n' + '\t' +
												o.getComment() + '\n';
									}
									tableOrder.setText(infoText);
								}
							}
						}
					});
					
					try {t = tableList.pop();}
					catch (Exception e){System.out.println("All tables are added to the map");}
				} //End of if
				else{
					tableButton = new JButton();
					tableButton.setBackground(Color.gray);
				}
			;
				
				tableNumber++;
				
				gridPanel.add(tableButton);
				
			}
		}
		
		JPanel waiterPanel = new JPanel(new GridLayout(1,2,10,10));
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				logout();
			}
		});
		
		JButton placeOrderButton = new JButton("Add Order");
		placeOrderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//placeOrder();
			}
		});
		
		JButton setDirtyButton = new JButton("Dirty Table");
		setDirtyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setDirty();
			}
		});

		waiterPanel.add(new JLabel(waiterName));
		waiterPanel.add(logoutButton);
		
		JPanel infoPanel = new JPanel(new GridBagLayout());
		tableInfo.setText("Please Select A Table");
		
		GridBagConstraints infoC = new GridBagConstraints();
			infoC.gridx = 0;
			infoC.gridy = 0;
			infoC.gridwidth = 2;
		infoPanel.add(tableInfo, infoC);
		
		GridBagConstraints orderC = new GridBagConstraints();
			orderC.gridx = 0;
			orderC.gridy = 1;
			orderC.gridwidth = 2;
		JScrollPane scrollPane = new JScrollPane(tableOrder,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setMinimumSize(new Dimension(250, 250));
		infoPanel.add(scrollPane, orderC);
		
		GridBagConstraints placeOrderC = new GridBagConstraints();
			placeOrderC.gridx = 0;
			placeOrderC.gridy = 2;
			placeOrderC.gridwidth = 1;
		infoPanel.add(placeOrderButton, placeOrderC);
		
		GridBagConstraints dirtyButtonC = new GridBagConstraints();
			dirtyButtonC.gridx = 1;
			dirtyButtonC.gridy = 2;
			dirtyButtonC.gridwidth = 1;
		infoPanel.add(setDirtyButton, dirtyButtonC);
		
		setSize(800,600);  
		getContentPane().add(gridPanel,BorderLayout.CENTER);
		getContentPane().add(waiterPanel,BorderLayout.NORTH);
		getContentPane().add(infoPanel,BorderLayout.EAST);
		pack();        
		setResizable(false);
		setVisible(true);
	}
	
	
	/**
	 * This method is called whenever a waiter clicks on the logout button. It will close the WaiterUI window, and bring back
	 * the login window.
	 */
	public void logout(){
		opener.setVisible(true);
		this.dispose();
	}
	
	private void setDirty(){
		if(selectedButton.getBackground() == Color.yellow){
			selectedButton.setBackground(Color.red);
			System.out.println("Table "+tableNumber+" is dirty");
			for(Table t : tableList){
				if(t.getTableNumber() == tableNumber){
					t.setStatus(Color.red);
				}
			}
		}
	}
}

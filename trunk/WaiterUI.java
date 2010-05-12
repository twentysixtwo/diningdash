import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * WaiterUI is the user interface for the waiter. It allows the waiter to add
 * orders to the bill of a table. It also allows the waiter to set the table
 * as dirty when the patrons leave. In case of user errors, the status of the
 * table can be toggled between occupied and dirty.
 * @author Henry Chao
 */

public class WaiterUI extends JFrame{

	/**
	 * Reference to the login screen that opened this WaiterUI
	 */
	LoginUI opener;
	
	JPanel gridPanel;
	JButton selectedButton;
	final static JTextArea tableOrder = new JTextArea(20, 25);
	final static JLabel tabLabel = new JLabel("Total Price: ");
	
	int x;
	int y;
	
	int MAX_ROWS;
	int MAX_COLUMNS;
	
	static int tableNumber;
	
	String waiterName;
	static String infoText = new String();
	static Bill tableBill = null;
	static double totalTab = 0;
	static LinkedList<Table> tableList;
	
	/**
	 * This is the constructor for the WaiterUI class and is called whenever a 
	 * new waiter window is needed. It generates the window, and displays the 
	 * up to date map of the restaurant, including the status of every table.
	 */
	public WaiterUI(LoginUI loginWindow,String name){
		super("Waiter");
		waiterName = name;
		opener = loginWindow;
		
		opener.setVisible(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		waiterName = new String("Waiter "+ waiterName);
		
		DataKeeper dk = new DataKeeper();
		tableList = dk.getTables();
		
		
		// Size of restaurant is determined by the TotalRows and TotalCols field in DataKeeper's restaurantMap
		// To change size, adjust the constructor of Map class
		MAX_ROWS = DataKeeper.restaurantMap.getTotalRows();
		MAX_COLUMNS = DataKeeper.restaurantMap.getTotalCols();
		
		gridPanel = new JPanel(new GridLayout(MAX_ROWS,MAX_COLUMNS));
		
		JButton tableButton;
		final JLabel tableInfo = new JLabel();
		tableOrder.setEditable(false);
		tableOrder.setLineWrap(true);
		
		tableNumber = 1;
		int index = 0;
		Table t = tableList.get(index++);
		updateOrderView();
			
		for(y=0;y<MAX_ROWS;y++)
		{
			for(x=0;x<MAX_COLUMNS;x++)
			{
				if( (t.getPosRow() == y) && (t.getPosCol() == x)){
					tableButton = new JButton((t.getTableNumber()).toString());
					tableButton.setBackground(t.getStatus());
					
					tableButton.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent e){
							updateOrderView();
							selectedButton = (JButton)e.getSource();
							
							int seated = 0;
							String wName = new String();
							
							for(Table t : tableList){
								if(t.getTableNumber() == tableNumber){
									tableBill = t.getTableBill();
									seated = t.getNumSeat();
									wName = t.getName();
								}
							}
							if(selectedButton.getBackground() != Color.gray)
							{
								tableNumber = Integer.parseInt(selectedButton.getText());
								System.out.println("Table number is " + tableNumber);
								tableInfo.setText("<html>Table " + tableNumber + " Waiter :" + wName + "<p>" +
													"Occupancy: " + seated);
								tableInfo.setMinimumSize(new Dimension(200, 30));
							}
							updateOrderView();
						}
					});
					
					try {t = tableList.get(index++);}
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
				placeOrder();
			}
		});
		
		JButton setDirtyButton = new JButton("Toggle Dirty");
		setDirtyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				toggleDirty();
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
		
		GridBagConstraints tabC = new GridBagConstraints();
			tabC.gridx = 0;
			tabC.gridy = 2;
			tabC.gridwidth = 2;
		infoPanel.add(tabLabel, tabC);
		
		GridBagConstraints placeOrderC = new GridBagConstraints();
			placeOrderC.gridx = 0;
			placeOrderC.gridy = 3;
			placeOrderC.gridwidth = 1;
		infoPanel.add(placeOrderButton, placeOrderC);
		
		GridBagConstraints dirtyButtonC = new GridBagConstraints();
			dirtyButtonC.gridx = 1;
			dirtyButtonC.gridy = 3;
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
	
	/**
	 * This method will toggle the status of the table between occupied (yellow)
	 * and dirty (red).
	 */
	public String toggleDirty(){
		if(selectedButton.getBackground() == Color.yellow){
			selectedButton.setBackground(Color.red);
			System.out.println("Table "+tableNumber+" is dirty");
			for(Table t : tableList){
				if(t.getTableNumber() == tableNumber){
					t.setStatus(Color.red);
				}
			}
			return "Dirty";
		}
		else if(selectedButton.getBackground() == Color.red){
			selectedButton.setBackground(Color.yellow);
			System.out.println("Table "+tableNumber+" is occupied");
			for(Table t : tableList){
				if(t.getTableNumber() == tableNumber){
					t.setStatus(Color.yellow);
				}
			}
			return "Occupied";
		}
		return "?";
	}
	
	/**
	 * This method will place an order for the table. It calls a new instance
	 * of a MenuUI and passes the bill to the UI so that a new order can be added.
	 */
	Color tableColor = null;
	Bill b = null;
	public String placeOrder(){
		//Bill b = null;
		//Color tableColor = null;
		
		for(Table t : tableList){
			if(t.getTableNumber() == tableNumber){
				b = t.getTableBill();
				tableColor = t.getStatus();
			}
		}
		if( (b!= null) && (tableColor == Color.yellow)){
			MenuUI mui = new MenuUI(b);
			return "Menu loaded";
		}
		else return("Order not placed");
	}
	
	/**
	 * Updates the UI to show the bill of the table in the WaiterUI.
	 */
	static String updateOrderView(){
		for(Table t : tableList){
			if(t.getTableNumber() == tableNumber){
				tableBill = t.getTableBill();
				totalTab = tableBill.getTab();
			}
		}
		LinkedList<Order> foodOrders = tableBill.getOrders();
		if(foodOrders.size() == 0){
			tableOrder.setText(null);
			return "Order updated1";
		}
		else{
			infoText = new String();
			for(Order o:foodOrders){
				if(o.getFoodName() != null){
					infoText = infoText + o.getFoodName() + '\n' + '\t' + 
								o.getComment() + '\n' + '\t' + "$" + o.getPriceAsString()+"0" + '\n';
					tableOrder.setText(infoText);
					tabLabel.setText("Total Price: $" + totalTab + "0");
				}
			}
			return "Order updated2";
		}
	}
}

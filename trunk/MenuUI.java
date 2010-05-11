import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * MenuUI is the user interface for the food menu.
 * @author Henry Chao
 *
 */

@SuppressWarnings("serial")
public class MenuUI extends JFrame{

	JPanel gridPanel;

	int MENU_ROWS;
	int MENU_COLUMNS;
	JButton selectedButton;
	JButton previousButton = null;
	
	String foodName = null;
	String foodComment = null;
	
	Bill menuBill;
		
	/**
	 * This is the constructor for the MenuUI class and is called whenever a new menu window is needed.
	 */
	public MenuUI(Bill bi){
		
		menuBill = bi;
				
		MENU_ROWS = 4;
		MENU_COLUMNS = 3;
		
		gridPanel = new JPanel(new GridLayout(MENU_ROWS,MENU_COLUMNS));
		
		JButton menuButton = null;

		int x;
		int y;
		int index = 0;
		LinkedList<String> s = DataKeeper.getListOfMenu();
		String item = s.get(index++);
		
		for(y=0;y<MENU_ROWS-1;y++)
		{
			for(x=0;x<MENU_COLUMNS;x++)
			{
				if (item != null) menuButton = new JButton(item);
				menuButton.setBackground(Color.gray);
					
				menuButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						selectedButton = (JButton)e.getSource();
						
						if (previousButton == null) previousButton = selectedButton;

						if (selectedButton.getBackground() == Color.gray){
							previousButton.setBackground(Color.gray);
							selectedButton.setBackground(Color.yellow);
							previousButton = selectedButton;
							foodName = selectedButton.getText();
						}
						else if(selectedButton.getBackground() == Color.yellow){
							selectedButton.setBackground(Color.gray);
							previousButton.setBackground(Color.gray);
							foodName = null;
						}
					}
				});
				
				gridPanel.add(menuButton);
				try {item = s.get(index++);}
				catch (Exception e){item = null;}
			};
		}

		final JTextField commentField = new JTextField();
		commentField.setText("Comments:");
		commentField.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent arg0) {
				if(commentField.isFocusOwner()){
					System.out.println(commentField.getText());
					if( (commentField.getText()).equals("Comments:"))
						commentField.setText(" ");
				}
			}

			public void focusLost(FocusEvent arg0) {
			}
			
		});
		gridPanel.add(commentField);
		
		JButton addOrderButton = new JButton("Add Order");
		addOrderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					foodComment = commentField.getText();
					if(foodComment.equals("Comments:")) foodComment = " ";
					menuBill.addOrder(foodName, foodComment);
					closeMenu();
					WaiterUI.updateOrderView();
			}
		});
		gridPanel.add(addOrderButton);
		
		JButton closeButton = new JButton("Cancel");
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					closeMenu();
			}
		});
		gridPanel.add(closeButton);

		setSize(600,600);
		getContentPane().add(gridPanel);     
		setResizable(false);
		setVisible(true);
	}
	
	
	/**
	 * This method is called whenever a waiter clicks on the logout button. It will close the WaiterUI window, and bring back
	 * the login window.
	 */
	public void closeMenu(){
		this.dispose();
	}
}

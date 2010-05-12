import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * MenuUI is the user interface for the food menu. Every time a waiter places an order,
 * the MenuUI will show up to display a grid of the available food items in the restaurant.
 * @author Henry Chao
 */

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
					String[] foodString = foodName.split("<html>|<p>|$");
					menuBill.addOrder(foodString[1], foodComment, foodString[2].substring(1));
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
	 * This method is called whenever a waiter clicks on the close button. It will close the MenuUI window, and bring back
	 * the WaiterUI window.
	 */
	public void closeMenu(){
		this.dispose();
	}
}

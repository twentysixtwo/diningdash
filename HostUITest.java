import java.awt.Color;

import javax.swing.JButton;

import junit.framework.TestCase;

public class HostUITest extends TestCase {
	
	LoginUI temp = new LoginUI();
	HostUI test = new HostUI(temp, "Tester");

	public void testSeatOne(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.green);
		test.tableNumber = 5;
		assertEquals(test.assignTable("Bob", 1),"Table assigned");
	}
	
	public void testSeatTwo(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.green);
		test.tableNumber = 5;
		assertEquals(test.assignTable("Bob", 2),"Table assigned");
	}
	
	public void testSeatThree(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.green);
		test.tableNumber = 5;
		assertEquals(test.assignTable("Bob", 3),"Table assigned");
	}
	
	public void testSeatFour(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.green);
		test.tableNumber = 5;
		assertEquals(test.assignTable("Bob", 4),"Table assigned");
	}
	
	public void testSeatOccupied(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.yellow);
		test.tableNumber = 5;
		assertEquals(test.assignTable("Bob", 2),"Table not assigned");
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner.run(HostUITest.class);
	}
}

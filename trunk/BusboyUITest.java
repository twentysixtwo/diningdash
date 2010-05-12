import java.awt.Color;

import javax.swing.JButton;

import junit.framework.TestCase;

public class BusboyUITest extends TestCase{

	LoginUI temp = new LoginUI();
	BusboyUI test = new BusboyUI(temp, "Tester");
	
	public void testCleanRedTable(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.red);
		test.tableNumber = 5;
		assertEquals(test.cleanTable(),"Table "+test.tableNumber+" is clean");
		assertEquals(test.selectedButton.getBackground(),Color.green);
	}
	
	public void testCleanGreenTable(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.green);
		test.tableNumber = 5;
		assertEquals(test.cleanTable(),"Table "+test.tableNumber+" is not clean");
		assertEquals(test.selectedButton.getBackground(),Color.green);
	}
	
	public void testCleanGrayTable(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.gray);
		test.tableNumber = 5;
		assertEquals(test.cleanTable(),"Table "+test.tableNumber+" is not clean");
		assertEquals(test.selectedButton.getBackground(),Color.gray);
	}
	
	public void testCleanNoNumber(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.red);
		//test.tableNumber;
		assertEquals(test.cleanTable(),"Table "+test.tableNumber+" is not clean");
		assertEquals(test.selectedButton.getBackground(),Color.green);
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner.run(BusboyUITest.class);
	}
}

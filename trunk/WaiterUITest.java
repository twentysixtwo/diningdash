import java.awt.Color;

import javax.swing.JButton;

import junit.framework.TestCase;

public class WaiterUITest extends TestCase{

	LoginUI temp = new LoginUI();
	WaiterUI test = new WaiterUI(temp, "Tester");
	
	public void testLoadMenu(){
		test.tableColor = Color.yellow;
		test.b = new Bill(new Waiter("Tester", 10), new Table(4, 4,"4", 0, 0, 0, 0));
		assertEquals(test.placeOrder(),"Menu loaded");
	}
	
	public void testUpdateOrderEmpty(){
		assertEquals(test.updateOrderView(),"Order updated1");
	}
	
	public void testUpdateOrder(){
		test.tableBill.addOrder("test", "", "1");
		test.tableBill.addOrder("test2", "", "2");
		assertEquals(test.updateOrderView(),"Order updated2");
	}
	
	public void testToggleDirty(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.yellow);
		assertEquals(test.toggleDirty(),"Dirty");
	}
	
	public void testToggleOccupied(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.red);
		assertEquals(test.toggleDirty(),"Occupied");
	}
	
	public void testToggleEmpty(){
		test.selectedButton = new JButton();
		test.selectedButton.setBackground(Color.green);
		assertEquals(test.toggleDirty(),"?");
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner.run(WaiterUITest.class);
	}
}

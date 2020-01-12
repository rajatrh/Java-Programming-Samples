package order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import items.MenuItem;

/* 
 * Order object contains a lot of information
 */

public class Order {
	
	/* 
	 * Order Status Enumerator
	 */
	
	public static enum OrderStatus {
		QUEUED("Queued"),
		PREPPING("Being Prepared"),
		PREPARED("Ready to be Served"),
		SERVED("Served");
	    private String value;

	    OrderStatus(final String value) {
	        this.value = value;
	    }
	    public String getValue() {
	        return value;
	    }
	    @Override
	    public String toString() {
	        return this.getValue();
	    }
	}
	public int id;
	public OrderStatus orderStatus;
	public String customerName;
	public long timeOfOrder;
	public ArrayList<MenuItem> items;
	public Bill bill;
	public boolean isPaid;
	
	/* 
	 * Order constructor
	 */
	
	public Order(int id, String customer) {
		this.id = id;
		this.customerName = customer;
		this.timeOfOrder = new Date().getTime();
		this.items = new ArrayList<MenuItem>();
		this.isPaid = false;
	}
	
	/* 
	 * Add a MenuItem into the order object
	 */
	
	public void addItem(MenuItem item) {
		items.add(item);
	}
	
	/* 
	 * Change the status of the order and delegate the next task to kitchen.
	 */
	
	public void sendOrderToKitchen() {
		orderStatus = OrderStatus.QUEUED;
	}
	
	/* 
	 * Override the toString() method
	 */
	
	public String toString() {
		String ret = "\n" + this.id + "# " + this.customerName + 
				" # " + this.orderStatus + "\n";
		if (this.orderStatus == OrderStatus.QUEUED || this.orderStatus == OrderStatus.QUEUED) {
			ret += "Placed @ " + ((new Date().getTime() - this.timeOfOrder)/1000 + " seconds ago");
		} else {
			ret += "Placed @ " + new Date(this.timeOfOrder).getTime();
		}
		
		Iterator<MenuItem> itemIterator = this.items.iterator();
		int i = 0;
		
		ret += "\n=========================================\n";
		while(itemIterator.hasNext()) {
			i++;
			ret += i + " @ " + itemIterator.next();
			ret += "\n-----------------------------------------\n";
		}
		return ret;
	}
}

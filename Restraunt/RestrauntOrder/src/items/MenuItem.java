package items;
import java.util.Scanner;

/* 
 * MenuItem is an Abstract class that needs to be extended
 * by all the items on the menu.
 * 
 * It has 
 * pickItem() for getting copies of 
 */

public abstract class MenuItem {
	
	/*
	 * mustHaves for all the MenuItems
	 */
	
	protected int id;
	double basePrice;
	String itemName;
	
	/*
	 * constructor
	 */
	
	 
    public int getId() {
        return this.id;
    }
 
    public void setId(int num) {
        this.id = num;
    }
    
	MenuItem(int id, String name, double price) {
		this.basePrice = price;
		this.itemName = name;
		this.id = id;
	}
	
	/*
	 * makeItem is for customization of the item
	 */
	

	public void makeItem(Scanner userInput) {
		
	}
	
	/*
	 * returns a copy of the object
	 */
	
	public MenuItem pickItem() {
		return null;
	}
}

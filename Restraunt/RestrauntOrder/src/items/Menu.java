package items;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import items.RiceBowl;

/*
 * Menu class
 */

public class Menu {
	
	/*
	 * List of all the menu items
	 */
	
	public ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	/*
	 * constructor
	 * Adding an instance of RiceBowl to MenuItems
	 */
	
	public Menu() {
		menuItems.add(new RiceBowl(0, "Rice Bowl", 5.0));
	}
	
	/*
	 * choosing the item from the menu and further customizing it
	 */
	
	public MenuItem chooseItem(int index, Scanner userInput) {
		MenuItem item = menuItems.get(index).pickItem();
		item.makeItem(userInput);
		return item;
	}
	
	/*
	 * configuring the menu
	 * Not implemented
	 */
	
	public boolean addUpdateItemToMenu() {
		return true;
	}
	
	/*
	 * List items in the menu for the user to choose from
	 */
	
	public void listItems() {
		Iterator<MenuItem> itemIterator = menuItems.iterator();
		int i = 0;
		while(itemIterator.hasNext()) {
			System.out.println(i + ") " + itemIterator.next().itemName);
		}
	}
}

package restaurant;

import java.util.ArrayList;
import java.util.Scanner;

import analytics.Report;
import items.Menu;
import order.Order;

public class Restaurant {
	static Scanner userInput =new Scanner(System.in);
	static ArrayList<Order> ordersForToday;
	static Menu hotelMenu;
	static Report report;

	public static void main(String[] args) {
		// Menu Object for the Restaurant
		hotelMenu = new Menu();
		
		// List of Orders for today (or hourly). This list can be saved to secondary memory
		ordersForToday = new ArrayList<Order>();
		
		//Generate new report object
		report = new Report();
		
		/* ######################
		 * CURRENT OPTIONS
		 * ######################
		 * 
		 * TAKE ORDER
		 * Print the menu and build the order
		 * 
		 * CHECK THE STATUS OF ORDER
		 * 
		 * PREPARE FOOD
		 * Just to update the status of the order (To view it in the report)
		 * 
		 * VIEW STATS
		 * As part of the requirements
		 * 
		 * ######################
		 * FURTHER ENHANCEMENTS
		 * ######################
		 * 
		 * ROLES
		 * These functions can be further controlled through employee objects
		 * Waiter,Manager and Chef
		 * 
		 * KITCHEN
		 * This could be a new feature by itself.
		 * 
		 * MENU CONFIGURATION
		 * Other options could be add items to menu or remove items from menu etc.
		 * Change the price for add ons.
		 * 
		 */
		while(true) {
			
			/*
			 * Main menu for the user to choose from
			 */
			
			System.out.println("1) ORDER FOOD");
			System.out.println("2) ORDER STATUS");
			System.out.println("3) PREPARE FOOD");
			System.out.println("4) VIEW STATS");
			System.out.println("5) EXIT");
			System.out.println("PLEASE SELECT AN OPTION:");
		
		    int choice = userInput.nextInt();
		    switch(choice) {
		    
		    /*
			 * Lets go ahead and build an order Object
			 */
		    
			case 1: Order newOrder = placeOrder(hotelMenu, ordersForToday.size());
					newOrder.sendOrderToKitchen();
					System.out.println("\nOrder Placed! ID: " + newOrder.id);
					System.out.println(newOrder);
					ordersForToday.add(newOrder);
					break; 
					/*
					 * Checking the status of the order
					 */
			case 2: checkStatus();
					break;
					/*
					 * Updating the status of the order
					 */
			case 3: updateStatus();
				break;
					/*
					 * View the reports
					 */
			case 4: viewReports();
				break;
					/*
					 * Exit from the menu
					 */
			case 5: System.out.println("Thanks for visiting!");
					userInput.close();
					return;
			default: System.out.println("Invalid Input!");
			}
		}
		
	}
	
	public static Order placeOrder(Menu hotelMenu, int id) {
		
		/*
		 * Create Order Object and add items to it.
		 * 
		 * To avoid complexity, adding order Id as the index
		 * of the order in the ordersForToday Array.
		 * 
		 * For now the customer name is "Rajat"
		 * 
		 */
		
		Order newOrder = new Order(id, "Rajat");
		
		int exitCase = hotelMenu.menuItems.size();
		int choice = -1;
		
		while(true) {
			hotelMenu.listItems();

			System.out.println(exitCase +  ") EXIT");
			System.out.println("PLEASE SELECT AN OPTION:");
			
			choice = userInput.nextInt();
			
			if (choice == exitCase) {
				break;
			}
			
			/*
			 * Choose item from menu.
			 */
			
			newOrder.addItem(hotelMenu.chooseItem(choice, userInput));
		}
		
		/*
		 * Update the reports, both hourly and overall
		 */
		report.updateQueue(newOrder);
		return newOrder;
	}
	
	public static void checkStatus() {
		System.out.println("\n\n Order ID:");
		
		int choice = userInput.nextInt();
		
		System.out.println(ordersForToday.get(choice));
	}
	
	public static void updateStatus() {
		// This work belongs to the Kitchen
		System.out.println("\n\n Order ID:");
		
		int choice = userInput.nextInt();
		
		ordersForToday.get(choice).orderStatus = Order.OrderStatus.SERVED;
		System.out.println(ordersForToday.get(choice));
	}
	
	public static void viewReports() {
		report.printReport();
	}
}

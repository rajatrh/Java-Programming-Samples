package analytics;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import items.RiceBowl;
import order.Order;
import items.MenuItem;

/*
 * Run statistics/reports that list the following in “last 1 hour”:
 a.	Total number of rice bowls.
 b.	Total number of rice bowls with chicken
 c.	Total number of rice bowls with beef
 d.	Total number of rice bowls with mixed vegetables.
 */

public class Report {
	
	// Overall Data for the day result map
	Map<String, Integer> results = new HashMap<>();
	
	// Queue to maintain last one hour orders
	Queue<Order> hourlyData;
	
	//Last 1 hour result map
	Map<String, Integer> hourly_results = new HashMap<>();
	
	
	final String RICE_BOWLS = "Total number of rice bowls";
	final String RICE_BOWLS_CHICKEN = "Total number of rice bowls with chicken";
	final String RICE_BOWLS_BEEF = "Total number of rice bowls with beef";
	final String RICE_BOWLS_VEGGIES = "Total number of rice bowls with mixed vegetables";
	
	/* 
	 * Constructor. Maps are set up here.
	 */
	
	public Report() {
		hourlyData = new LinkedList<>();
		
		results.put(RICE_BOWLS, 0);
		results.put(RICE_BOWLS_CHICKEN, 0);
		results.put(RICE_BOWLS_BEEF, 0);
		results.put(RICE_BOWLS_VEGGIES, 0);
		
		hourly_results.put(RICE_BOWLS, 0);
		hourly_results.put(RICE_BOWLS_CHICKEN, 0);
		hourly_results.put(RICE_BOWLS_BEEF, 0);
		hourly_results.put(RICE_BOWLS_VEGGIES, 0);
	}
	
	/* 
	 * Main method called when user selects option 4 in the restaurant main menu.
	 */
	
	public void printReport() {
		updateQueue();
		outputMap(results, "OVERALL RESULTS");
		outputMap(hourly_results, "HOURLY RESULTS ");
	}
	
	/* 
	 * Update Map, could either add or remove from it
	 */
	
	public void addToMap(Map<String, Integer> m, int[] res) {
		m.put(RICE_BOWLS, m.get(RICE_BOWLS) + res[0]);
		m.put(RICE_BOWLS_VEGGIES, m.get(RICE_BOWLS_VEGGIES) + res[1]);
		m.put(RICE_BOWLS_CHICKEN, m.get(RICE_BOWLS_CHICKEN) + res[2]);
		m.put(RICE_BOWLS_BEEF, m.get(RICE_BOWLS_BEEF) + res[3]);
	}
	
	public void removeFromMap(Map<String, Integer> m, int[] res) {
		m.put(RICE_BOWLS, m.get(RICE_BOWLS) - res[0]);
		m.put(RICE_BOWLS_VEGGIES, m.get(RICE_BOWLS_VEGGIES) - res[1]);
		m.put(RICE_BOWLS_CHICKEN, m.get(RICE_BOWLS_CHICKEN) - res[2]);
		m.put(RICE_BOWLS_BEEF, m.get(RICE_BOWLS_BEEF) - res[3]);
	}
	
	/* 
	 * Output format for the report
	 */
	
	public void outputMap(Map<String, Integer> m, String heading) {
		System.out.println("\n\n--------------------------------------------------------------");
		System.out.println(heading);
		System.out.println("--------------------------------------------------------------");
		for (Map.Entry e : m.entrySet()) { 
            System.out.println((String)e.getKey() + " | " + e.getValue());
            System.out.println("--------------------------------------------------------------");
        } 
	}
	
	/*
	 * Extract the required counts from any order.
	 * Can add the implementation to that particular MenuItem.
	 */
	
	public int[] extractCountsFromOrder(Order order) {
		int[] res = new int[] {0, 0, 0, 0};
		for (MenuItem item : order.items) {
			
			if(item.getId() == 0) { // Check if it is a RiceBowl
				res[0]++;
				RiceBowl rb = (RiceBowl)item;
				
				if (rb.isMixedVeggiesAdded()) {
					res[1]++;
				}
				if (rb.getMeatType() == RiceBowl.MeatType.CHICKEN) {
					res[2]++;
				}
				if (rb.getMeatType() == RiceBowl.MeatType.BEEF) {
					res[3]++;
				}
			}
		}
		
		return res;
	}
	
	
	/* 
	 * Utility function to update hourly_queue and result
	 * maps once a new order comes in.
	 */
	
	public void updateQueue(Order order) {
		int[] res = extractCountsFromOrder(order);
		addToMap(hourly_results, res);
		addToMap(results, res);
		hourlyData.add(order);
		updateQueue();
	}
	
	/* 
	 * Utility function to update hourly_queue based in time stamp and result map.
	 * Called from updateQueue(Order order) and printReport().
	 */
	
	public void updateQueue() {
		Order head = hourlyData.peek();
		if (head != null) {
			long currentTime = new Date().getTime();
			
			/* 
			 * As per the requirements the threshold for buffer is 1 Hour.
			 * But I have considered the buffer to be 60000 milliseconds = 1 minute.
			 * This change has been made so that the results are apparent
			 * and can be seen real time.
			 * 
			 */
			
			
			while(head != null && currentTime - head.timeOfOrder > 60000) {
				System.out.println("Removing " + head);
				int[] res = extractCountsFromOrder(head);
				removeFromMap(hourly_results, res);
				hourlyData.remove();
				head = hourlyData.peek();
			}
		}
	}
}

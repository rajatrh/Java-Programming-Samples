package restaurant;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import items.MenuItem;
import items.RiceBowl;
import order.Order;

class RestaurantTest {

	@Test
	void test() {
		
		/* 
		 * Test case to verify the instantiation of Order and MenuItem -> RiceBowl classes.
		 */
		
		Order newOrder = new Order(1, "TestUser" );
		MenuItem newItem = new RiceBowl(130, "RiceBowl", 5);
		newOrder.addItem(newItem);
		
		assertEquals(newOrder.items.get(0).getId(), 120);
		
		RiceBowl riceBowl = (RiceBowl) newOrder.items.get(0);
		riceBowl.setMeatType(RiceBowl.MeatType.CHICKEN);
		
		assertEquals(riceBowl.getMeatType(), RiceBowl.MeatType.CHICKEN);
	}

}

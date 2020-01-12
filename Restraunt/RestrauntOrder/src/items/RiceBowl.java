package items;
import java.util.Scanner;

/*
 * Customize the creation of a rice bowl dish for customer using the following options
 * Add white or brown rice
 * Add mixed vegetables or skip.
 * Add a choice of meat – chicken or beef
 * Add a choice of sauce – spicy or sweet
 * Add sour cream or skip
 * Add guacamole or skip    
 * It should print the details of the order when order is placed.
 */

/* 
 * One of the items on Menu.
 * Every item on menu needs to extend the abract class MenuItem and override it's methods
 */

public class RiceBowl extends MenuItem {
	
	/* 
	 * Enumerator for Rice Type
	 * Adding a string value 
	 */
	
	public static enum RiceType {
		WHITE("White Rice"),
	    BROWN("Brown Rice");
	    private String value;

		RiceType(final String value) {
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
	
	/* 
	 * Enumerator for Meat Type
	 * Adding a string value 
	 */
	
	public static enum MeatType {
		CHICKEN("Chicken"),
	    BEEF("Beef");
	    private String value;

	    MeatType(final String value) {
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
	
	/* 
	 * Enumerator for Sauce Type
	 * Adding a string value 
	 */
	
	public static enum SauceType {
		SPICY("Spicy"),
	    SWEET("Sweet");
	    private String value;

	    SauceType(final String value) {
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
	
	/* 
	 * Member variables consisting of Rice Type, Meat Type, Sauce Type
	 * Booleans for Mixed Vegetables, Sour Cream and Guac
	 */
	
	private RiceType riceType;
	private MeatType meatType;
	private SauceType sauceType;
	private boolean addMixedVeggies;
	private boolean addSourCream;
	private boolean addGuacamole;
	
	public boolean isMixedVeggiesAdded() {
        return this.addMixedVeggies;
    }
 
    public void setMixedVeggiesAdded(boolean b) {
        this.addMixedVeggies = b;
    }
    
    public MeatType getMeatType() {
        return this.meatType;
    }
 
    public void setMeatType(MeatType m) {
        this.meatType = m;
    }
	
	/* 
	 * Constructor for RiceBowl. Assign Id, name, and base Price (MenuItem)
	 */
	
	public RiceBowl(int id, String name, double d) {
		super(id, name, d);
	}
	
	/* 
	 * Create a copy of this item and return the reference to Menu Item.
	 * This is done to enable runtime polymorphism 
	 */
	
	public RiceBowl pickItem() {
		return new RiceBowl(this.id, this.itemName, this.basePrice);
		
	}
	
	/* 
	 * Build the item through different options
	 */

	public void makeItem(Scanner input) {
		int choice;
		System.out.println("Would you like to have White (0) or Brown Rice (1)?");
		choice = input.nextInt();
		this.riceType = RiceType.values()[choice];
		
		System.out.println("Should I add mixed Vegetables or not? (Yes - 1/ No - 0)");
		choice = input.nextInt();
		this.addMixedVeggies  = choice == 1? true: false;
		
		System.out.println("Which meat do you prefer, Chicken (0) or Beef (1)?");
		choice = input.nextInt();
		this.meatType = MeatType.values()[choice];
		
		System.out.println("How would you like the taste? Spicy (0) or Sweet (1)?");
		choice = input.nextInt();
		this.sauceType  = SauceType.values()[choice];
		
		System.out.println("Should I add sour cream or not? (Yes - 1/ No - 0)");
		choice = input.nextInt();
		this.addSourCream  = choice == 1? true: false;

		System.out.println("Do you want me to add gauc as well? (Yes - 1/ No - 0)");
		choice = input.nextInt();
		this.addGuacamole  = choice == 1? true: false;
		
		System.out.println("\nAdded " + this + "\n\n");
	}
	
	/* 
	 * override toString
	 */
	
	public String toString() {
		String ret = " RiceBowl (" + this.riceType + "," + this.meatType + "," + this.sauceType; 
		
		if (this.addMixedVeggies) {
			ret += ",Mixed Veggies";
		}
		
		if (this.addGuacamole) {
			ret += ",Guac";
		}
	
		if (this.addSourCream) {
			ret += ",SourCream";
		}
		
		ret += ")";
		return ret;
		
	}
}

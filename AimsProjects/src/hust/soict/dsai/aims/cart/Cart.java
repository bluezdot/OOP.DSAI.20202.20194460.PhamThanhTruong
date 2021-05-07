package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media m) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full !");
		}
		else {
			if (itemsOrdered.contains(m)) {
				System.out.println("The media is already in the cart");
			}
			else {
				itemsOrdered.add(m);
				System.out.println("The media has added");
			}
		}
	}
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void removeMedia(Media m) {
		if (itemsOrdered.contains(m)) {
			itemsOrdered.remove(m);
			System.out.println("The media has been removed");
		}
		else {
			System.out.println("The media is not in the cart");
		}
	}
	
	public float totalCost() {
		float total = 0;
		for (Media m : itemsOrdered) {
			total = total + m.getCost();
		}
		return total;
	}

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (Media m : itemsOrdered) {
			if (m != null) {
				System.out.print(Integer.toString(j+1) + ". ");
				m.getDetail();
			}
			else {
				break;
			}
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
		
	}
	
	public void search(String title) {
		boolean check = false;
		for (Media m : itemsOrdered) {
			if (m == null) {
				break;
			}
			if (m.search(title)) {
				check = true;
				m.getDetail();
			}
		}
		if (! check) {
			System.out.println("No match is available");
		}
	}
	
	public void search(int id) {
		boolean check = false;
		for (Media m : itemsOrdered) {
			if (m == null) {
				break;
			}
			if (m.getId() == id) {
				check = true;
				m.getDetail();
				break;
			}
		}
		if (! check) {
			System.out.println("No match is available");
		}
	}
}

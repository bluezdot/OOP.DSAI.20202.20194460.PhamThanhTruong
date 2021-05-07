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

	public void display() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].getTitle());
		}
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int j = 0; j < MAX_NUMBERS_ORDERED; j++) {
			if (itemsOrdered[j] != null) {
				System.out.print(Integer.toString(j+1) + ". ");
				itemsOrdered[j].getDetail();
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
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] == null) {
				break;
			}
			if (itemsOrdered[i].search(title)) {
				check = true;
				itemsOrdered[i].getDetail();
			}
		}
		if (! check) {
			System.out.println("No match is available");
		}
	}
	
	public void search(int id) {
		boolean check = false;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] == null) {
				break;
			}
			if (itemsOrdered[i].getId() == id) {
				check = true;
				itemsOrdered[i].getDetail();
				break;
			}
		}
		if (! check) {
			System.out.println("No match is available");
		}
	}
}

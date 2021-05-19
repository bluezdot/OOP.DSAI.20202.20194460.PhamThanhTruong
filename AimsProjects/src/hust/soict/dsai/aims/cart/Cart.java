package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public void addMedia(Media m) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full !");
		}
		else {
			//if (itemsOrdered.contains(m)) {
			//	System.out.println("The media is already in the cart");
			//}
		//	else
			{
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
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
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
				System.out.println(m.toString());
			}
		
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
		
	}
	
	public Media searchMedia(int x) {
		boolean found = false;
		Media result = null;
		for (Media media: itemsOrdered) {
			if (media.search(x)) {
				found = true;
				result = media;
			}
		}
		if (found == false) {
			System.out.println("This DVD is not in cart");
			return result;
		}
		else {
			System.out.println(result.toString());
			return result;
		}
	}
	
	public ArrayList<Media> searchMedia(String name) {
		boolean found = false;
		ArrayList<Media> result = new ArrayList<Media>();
		for (Media media: itemsOrdered) {
			if (media.search(name)) {
				result.add(media);
				System.out.println(media.toString());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("This DVD is not in cart");
		}
		return result;
	}
	
}

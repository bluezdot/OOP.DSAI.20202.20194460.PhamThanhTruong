package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 20) {
			System.out.println("The cart is almost full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
	}

	// Method to add an array of DVDs into Cart
//	void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		for (int i = 0; i < dvdList.length; i ++) {
//			if (qtyOrdered == 20) {
//				System.out.println("The cart is almost full");
//				break;
//			}
//			else if (dvdList[i] == null){
//				break;
//			}
//			else {
//				itemsOrdered[qtyOrdered] = dvdList[i];
//				qtyOrdered ++;
//			}
//		}
//		System.out.println("The cart has already renewed");
//	}

	// Method to add an arbitrary number of arguments for dvds (Varargs)
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			if (qtyOrdered == 20) {
				System.out.println("The cart is almost full");
				break;
			} else if (dvdList[i] == null) {
				break;
			} else {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
			}
		}
		System.out.println("The cart has already renewed");
	}
	// Comment: With this method, we can also pass an array of DVDs, zero parameter
	// also any number DVDs as parametor of method.
	// Save time, code, memory because we don't need to create overload method
	// Disadventage: We can put just varargs for one argument, varargs argument must
	// stand in the last of the list of arguments
	// In this case, I prefer you Varargs, because the input of method is only DVDs
	// or list of DVDs (1 argument type)

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered == 19) {
			System.out.println("The cart does not have enough space for adding list of dvds");
		} else {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered + 1] = dvd2;
			qtyOrdered += 2;
			System.out.println("The discs has been added");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int j = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				j = i;
				break;
			}
		}

		for (int i = j; i < qtyOrdered; i++) {
			itemsOrdered[i] = itemsOrdered[i + 1];
			qtyOrdered--;
		}
		System.out.println("The disc has been removed");
	}

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}

	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
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

package aims;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrdered = 0;

	void addDigitalVideoDisc(DigitalVideoDisc disc) {
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
	void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
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

	void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered == 19) {
			System.out.println("The cart does not have enough space for adding list of dvds");
		} else {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered + 1] = dvd2;
			qtyOrdered += 2;
			System.out.println("The discs has been added");
		}
	}

	void removeDigitalVideoDisc(DigitalVideoDisc disc) {
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

	void display() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].getTitle());
		}
	}
	
	public void getDetail() {
		
	}
}

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

	void display() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i]);
		}
	}
}

package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 999999;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
	private int qtyStore;

	public boolean checkDVD(DigitalVideoDisc disc) {
		boolean check = false;
		for (int i = 0; i < qtyStore; i++) {
			if (itemsInStore[i].equals(disc)) {
				check = true;
				break;
			}
		}
		return check;
	}

	public void addDVD(DigitalVideoDisc... discsList) {
		for (DigitalVideoDisc disc : discsList) {
			if (checkDVD(disc)) {
				System.out.println("The disc is already in store");
			} else {
				if (qtyStore >= MAX_NUMBERS_IN_STORE) {	
					System.out.println("The store is almost full");
					break;
				} else {
					itemsInStore[qtyStore] = disc;
					qtyStore += 1;
					System.out.println("The disc has been added to store");
				}
			}
		}
	}

	public void removeDVD(DigitalVideoDisc disc) {
		if (qtyStore > 0) {
			int indexOfDisc = 0;
			boolean discInStore = false;
			while (indexOfDisc < qtyStore) {
				if (itemsInStore[indexOfDisc] == disc) {
					discInStore = true;
					break;
				} else {
					indexOfDisc += 1;
				}
			}
			if (discInStore) {
				for (int i = indexOfDisc; i < qtyStore - 1; ++i) {
					itemsInStore[i] = itemsInStore[i + 1];
				}
				itemsInStore[qtyStore - 1] = null;
				qtyStore -= 1;
				System.out.println("The disc has been removed from store");
			} else {
				System.out.println("The disc is not in store");
			}
		} else {
			System.out.println("The store is empty");
		}
	}
	
}

package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 999999;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media m) {
		
		if (itemsInStore.contains(m)) {
			System.out.println("The media is already in the store");
		}
		else {
			itemsInStore.add(m);
			System.out.println("The media has been added to the store");
		}
	}
	
	public void addMedia(Media ... args ) {
		for (Media m: args) {
			if (itemsInStore.contains(m)) {
				System.out.println("The media is already in the store");
			}
			else {
				itemsInStore.add(m);
				System.out.println("The media has been added to the store");
			}
		}
	}
	
	public void removeMedia(Media m) {
		if (itemsInStore.contains(m)) {
			itemsInStore.remove(m);
			System.out.println("The media has been removed");
		}
		else {
			System.out.println("The media is not in the store");
		}
	}	
}

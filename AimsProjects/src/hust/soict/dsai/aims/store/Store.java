package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 999999;
	public ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media m) {
		
	//	if (itemsInStore.contains(m)) {
	//		System.out.println("The media is already in the store");
	//	}
		//else 
		{
			itemsInStore.add(m);
			System.out.println("The media has been added to the store");
		}
	}
	
	public void addMedia(Media ... args ) {
		for (Media m: args) {
			//if (itemsInStore.contains(m)) {
			//	System.out.println("  The media is already in the store");
			//}
			//else 
			{
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
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
	public ArrayList<Media> searchMedia(String name) {
		boolean found = false;
		ArrayList<Media> result = new ArrayList<Media>();
		int qtyResult = 0;
		for (Media media: itemsInStore) {
			if (media.search(name)) {
				result.add(media);
				qtyResult += 1;
				System.out.println(media.toString());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("This DVD is not in store");
		}
		return result;
	}
	public Media searchMedia(int x) {
		boolean found = false;
		Media result = null;
		for (Media media: itemsInStore) {
			if (media.search(x)) {
				found = true;
				result = media;
			}
		}
		if (found == false) {
			System.out.println("This DVD is not in store");
			return result;
		}
		else {
			System.out.println(result.toString());
			return result;
		}
	}
	

	public void print() {
		System.out.println("*STORE*");
		System.out.println("Items:");
		int i = 0;
		for (Media media: itemsInStore) {
			System.out.println((i+1) + ". " + media.toString());
			i += 1;
		}
		System.out.println("--------------------");
	}	
}

package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Title1", "Type1", "Name1", 80, 50);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Title2", "Type2", "Name2", 80, 30);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Title3", "Type3", "Name3", 80, 20);
		store.addMedia(dvd2, dvd3);
		
		store.removeMedia(dvd3);
		cart.addMedia(dvd3);
		cart.addMedia(dvd2);
		cart.addMedia(dvd1);
		new CartScreen(cart, store);
	}

}

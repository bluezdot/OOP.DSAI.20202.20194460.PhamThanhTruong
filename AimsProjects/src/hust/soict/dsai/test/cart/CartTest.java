package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class CartTest {

	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		Store store = new Store();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Title1", "Type1", "Name1", 80, 50);
		DigitalVideoDisc dvd21 = new DigitalVideoDisc("Title2", "Type2", "Name2", 80, 30);
		DigitalVideoDisc dvd31 = new DigitalVideoDisc("Title3", "Type3", "Name3", 80, 20);
		cart.addMedia(dvd31);
		cart.addMedia(dvd21);
		cart.addMedia(dvd11);
		
		// Add to store

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion","Animation","Roger Allers",87,19.95f);
		store.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		store.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		store.addMedia(dvd3);
		Book b = new Book(1, "Harry Porter", "Action" ,35.5f, "La");
		store.addMedia(b);
		CompactDisc cd = new CompactDisc("Lalisa", "Comedy", 123, "Truong");
		store.addMedia(cd);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Girl From Nowhere","Drama",18.99f);
		store.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Old Dad","Drama",18.99f);
		store.addMedia(dvd5);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Black Widow","Science Fiction",18.99f);
		store.addMedia(dvd6);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Tom & Jerry","Animation",18.99f);
		store.addMedia(dvd7);
		
		new CartScreen(cart, store);
	}

}
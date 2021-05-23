package hust.soict.dsai.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.store.Store;

public class CartTest {

	public static void main(String[] args) throws LimitExceededException, PlayerException {
		//Create a new cart
		Cart cart = new Cart();
		Store store = new Store();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Title1", "Type1", "Name1", -10, 50);
		DigitalVideoDisc dvd21 = new DigitalVideoDisc("Title2", "Type2", "Name2", 80, 30);
		DigitalVideoDisc dvd31 = new DigitalVideoDisc("Title3", "Type3", "Name3", 80, 20);
		cart.addMedia(dvd31);
		cart.addMedia(dvd21);
		cart.addMedia(dvd11);
		
		// Add to store

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion","Animation","Roger Allers",80,19.95f);
		store.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		store.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		store.addMedia(dvd3);
		Book b = new Book(1, "Harry Porter", "Action" ,35.5f, "La");
		store.addMedia(b);
		CompactDisc cd = new CompactDisc("Lalisa", "Comedy", 123, "Truong");
		Track track1 = new Track("track1", 10);
		Track track2 = new Track("track2", 20);
		Track track3 = new Track("track3", 30);
		
		cd.addTrack(track1);
		cd.addTrack(track2);
		cd.addTrack(track3);
		
		store.addMedia(cd);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Girl From Nowhere","Drama","La", 40, 18.99f);
		store.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Old Dad","Drama","La", 40, 18.99f);
		store.addMedia(dvd5);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Black Widow","Science Fiction","La", 40, 18.99f);
		store.addMedia(dvd6);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Tom & Jerry","Animation","La", 40, 18.99f);
		store.addMedia(dvd7);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Tom & Jerry 2","Animation","La", 40, 18.99f);
		store.addMedia(dvd8);
		
		new CartScreen(cart, store);
		
	}

}
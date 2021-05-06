package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Dragon Ball", "Animation", "Lucifer", 30, 15.95f);
		anOrder.addDigitalVideoDisc(dvd4);
		anOrder.removeDigitalVideoDisc(dvd4);
		
		// Print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.display();
		System.out.println("----------");
		
		// Add list of 2 dvds
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("title5", "type5", "name5", 80, 24.90f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("title6", "type6", "name6", 80, 24.90f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("title7", "type7", "name7", 80, 24.90f);
		anOrder.addDigitalVideoDisc(dvd5, dvd6, dvd7);
		anOrder.display();
	}
}
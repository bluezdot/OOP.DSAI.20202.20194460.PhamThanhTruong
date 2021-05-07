package hust.soict.dsai.aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;


public class Aims {

	public static void main(String[] args) {
		
		ArrayList<Media> mediae = new ArrayList<Media>();
	    CompactDisc cd = new CompactDisc("Title1", "Karish");
	    Book book = new Book(1, "Title1", "Cat1", 80, "Kaka");
	    mediae.add(cd);
	    mediae.add(book);
	    for (Media m : mediae) {
	    	System.out.println(m.toString());}
	}
}

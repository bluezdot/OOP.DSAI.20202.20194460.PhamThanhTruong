package hust.soict.dsai.aims;

import java.util.ArrayList;

import java.util.List;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;


public class Aims {

	public static void main(String[] args) {
		
		List<Media> mediae = new ArrayList<Media>();
	    Book book1 = new Book(1, "Title3", "Cat1", 100, "Kaka");
	    Book book2 = new Book(2, "Title2", "Cat2", 80, "Kaka");
	    mediae.add(book1);
	    mediae.add(book2);
	    
	    java.util.Collections.sort(mediae,Media.COMPARE_BY_TITLE_COST);
	    
	    for (Media m : mediae) {
	    	System.out.println(m.toString());}

	}
}

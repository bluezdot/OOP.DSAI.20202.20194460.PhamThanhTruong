package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
		private int id;
		private List<String> authors = new ArrayList<String>();
		
		public Book() {
		}
		
		public Book(int id, String title, String category, float cost, List<String> authors) {
			super();
			this.id = id;
			this.title = title;
			this.category = category;
			this.cost = cost;
			this.authors = authors;
		}
		
		public void addAuthor(String authorName) {
			if (this.authors.contains(authorName) == false) this.authors.add(authorName);
			else System.out.println("author is already in list");
		}
		public void removeAuthor(String authorName) {
			if (this.authors.contains(authorName) == true) this.authors.remove(authorName);
			else System.out.println("not exists");
		}
}

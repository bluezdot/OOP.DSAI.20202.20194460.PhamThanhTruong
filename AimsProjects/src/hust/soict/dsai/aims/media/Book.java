package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
		private int id;
		private ArrayList<String> authors = new ArrayList<String>();
		
		public Book() {
		}
		
		public Book(int id, String title, String category, float cost, String f) {
			super();
			this.id = id;
			this.title = title;
			this.category = category;
			this.cost = cost;
			this.authors.add(f);
		}
		
		public void addAuthor(String authorName) {
			if (this.authors.contains(authorName) == false) this.authors.add(authorName);
			else System.out.println("author is already in list");
		}
		public void removeAuthor(String authorName) {
			if (this.authors.contains(authorName) == true) this.authors.remove(authorName);
			else System.out.println("not exists");
		}
		
		public String toString() {
			return "ID : " + String.valueOf(id) + "; " +
	                "Title = '" + title + "'; "  +
	                "Category = '" + category + "'; " +
	                "Cost = " + cost + "; " +
	                "Authors = " + authors;
		}
}

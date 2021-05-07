package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public abstract class Media {
	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	protected LocalDate date;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
 
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}

	// override equals method
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media that = (Media) obj;
			return this.title.toLowerCase().equals(that.title.toLowerCase());
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "ID : " + String.valueOf(id) + "; " +
                "Title = '" + title + "'; "  +
                "Category = '" + category + "'; " ;
	}

}

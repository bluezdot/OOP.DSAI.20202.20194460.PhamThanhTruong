package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.dsai.aims.exception.PlayerException;

public abstract class Media {
	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	protected LocalDate date;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	
	public void play() throws PlayerException
	{
		
	}
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
	
	
	// Search
	public boolean search(String title) {
		String t1 = this.title.toLowerCase();
		String t2 = title.toLowerCase();
		if (t1.contains(t2)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean search(int id) {
		if (id == this.id) {
			return true;
		}
		else {
			return false;
		}
	}
	public Media(String title) {
        this.title = title;
    }

    public Media(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	
	
	@Override
	public String toString() {
		return "ID : " + String.valueOf(id) + "; " +
                "Title = '" + title + "'; "  +
                "Category = '" + category + "'; " ;
	}
//	public void print()
//	{
//		System.out.println("ID:"+String.valueOf(id)+";"+ "Title = "+ title + " ; ";);
//	}
//	
}

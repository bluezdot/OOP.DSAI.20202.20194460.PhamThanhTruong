package aims;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
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

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public float getCost() {
		return cost;
	}

	// The getDetail() method does not have return type, it will print out the String I construct whenever the method is called.
	public void getDetail() {
		System.out.printf("DVD - %s - %s - %s - %d: %f$\n", title, category, director, length, cost);
	}
	
	public boolean search(String title) {
		return this.title.contains(title);
	}

	public boolean search(int id) {
		if (id == this.id) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getId() {
		return id;
	}
}

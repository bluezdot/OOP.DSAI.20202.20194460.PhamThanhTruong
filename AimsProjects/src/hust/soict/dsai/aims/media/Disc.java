package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;

	public Disc()
	{
			
	}
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title) {
		super();
		super.title=title;
	}
	public Disc(String title, String category, float cost) {
		super();
		super.title=title;
		super.category=category;
		super.cost=cost;
	}
	public Disc(String title, String category, String director, float cost) {
		super();
		super.title=title;
		super.category=category;
		super.cost=cost;
		this.director=director;
	}
	public Disc(String title, String category, String director, int length, float cost ) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
	}
}

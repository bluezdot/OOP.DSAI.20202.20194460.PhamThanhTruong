package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title) {
		super();
	}
	public Disc(String title, String category, float cost) {
		super();
	}
	public Disc(String title, String category, String director, float cost) {
		super();
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super();
		this.director = director;
		this.length = length;
	}
}

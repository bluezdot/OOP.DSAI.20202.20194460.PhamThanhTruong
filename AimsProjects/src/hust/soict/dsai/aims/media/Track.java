package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	// Create Constructors
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public Track(String title) {
		super();
		this.title = title;
	}

	// Add method play()
	public void play() {
		if (this.length == 0) {
			System.out.println("Cannot play track " + this.getTitle());
		} else {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track that = (Track) obj;
			return (this.title.toLowerCase().equals(that.title.toLowerCase()) && this.length == that.length);
		} else {
			return false;
		}
	}
}

package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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

	
	@Override
    public void play() throws PlayerException {
        if (this.getLength() > 0){
            System.out.println(this.getTitle() +" is playing...");
        }else {
            throw new PlayerException("ERROR: Track length is non-positive!!!");
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

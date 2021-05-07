package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public int getLength() {
		return this.length;
	}

	// Create constructors

	public CompactDisc(String title, String artist, ArrayList<Track> tracks) {
		super(title);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
	}

	// Create add and remove method

	public boolean addTrack(Track t1) {
		if (tracks.contains(t1)) {
			System.out.println("The track is already in CD");
			return false;
		} else {
			tracks.add(t1);
			this.length += t1.getLength();
			System.out.println("The track has been added");
			return true;
		}
	}

	public void removeTrack(Track t1) {
		if (tracks.contains(t1)) {
			tracks.remove(t1);
			this.length -= t1.getLength();
			System.out.println("The track has been removed");
		} else {
			System.out.println("The track is not in CD");
		}
	}

	// Add method play()
	public void play() {
		System.out.println("CD's artist: " + this.getArtist());
		for (Track t: tracks) {
			t.play();
		}
	}
	
	public String toString() {
		return "ID : " + String.valueOf(id) + "; " +
                "Title = '" + title + "'; "  +
                "Category = '" + category + "'; " +
                "Cost = " + cost + "; " +
                "Artist = " + artist;
	}

}

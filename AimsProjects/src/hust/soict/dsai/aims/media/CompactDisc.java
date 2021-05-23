package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

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

	public CompactDisc(String title, String category, float cost, String artist) {
		super(title, category, cost);
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
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while ((iter.hasNext())) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!!!");
		}

	}

	public String toString() {
		return "CompactDisc: ID=" + String.valueOf(id) + ", Title=" + title + ", Category=" + category + ", Cost="
				+ cost + ", Artist=" + artist;
	}

}

package hust.soict.dsai.aims.media;

import java.awt.Frame;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.PlayerException;


public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	private int id;

	public DigitalVideoDisc()
	{
		
	}

	
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs;
	}

	public String getDirector() {
		return director;
	}

	

	// The getDetail() method does not have return type, it will print out the String I construct whenever the method is called.
	
	
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
	
	// Add method play()
	@Override
    public void play() throws PlayerException {
        if (this.getLength() >= 0){
        	Frame frame = new Frame();
	        JOptionPane.showMessageDialog(frame, "Length: " + this.getLength(), this.getTitle(), JOptionPane.DEFAULT_OPTION);
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!!!");
        }
    }

	@Override
	public String toString() {
		return "DigitalVideoDisc: director=" + director + ", length=" + length + ", id=" + id + ", title=" + title
				+ ", category=" + category + ", cost=" + cost ;
	}
	
	
}

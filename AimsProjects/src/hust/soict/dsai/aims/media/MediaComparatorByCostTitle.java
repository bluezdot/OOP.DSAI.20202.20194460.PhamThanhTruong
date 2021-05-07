package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		int costCompare = Float.compare(o1.getCost(), o2.getCost());
		int titleCompare = o1.getTitle().compareTo(o2.getTitle());
		return (costCompare == 0) ? titleCompare : costCompare;
	}

}

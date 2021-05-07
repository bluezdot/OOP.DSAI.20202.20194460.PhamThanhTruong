package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		int costCompare = Float.compare(o1.getCost(), o2.getCost());
		int titleCompare = o1.getTitle().compareTo(o2.getTitle());
		return (titleCompare == 0) ? costCompare : titleCompare;
	}
}

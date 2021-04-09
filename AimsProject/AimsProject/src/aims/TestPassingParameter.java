package aims;

public class TestPassingParameter {

	public static void main(String[] args) {
		// Old main
//		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
//		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
//
//		swap(jungleDVD, cinderellaDVD);
//		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
//
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		// New main
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		wrapper junglewrapper = new wrapper(jungleDVD);
		wrapper cinderellawrapper = new wrapper(cinderellaDVD);
		correct_swap(junglewrapper, cinderellawrapper);
		System.out.println("After swap");
		System.out.println("jungle dvd title: " + junglewrapper.tmp.getTitle());
		System.out.println("cinderella dvd title: " + cinderellawrapper.tmp.getTitle());
		System.out.println();
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}

//	public static void swap(Object o1, Object o2) {
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
//	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}



	public static void correct_swap(wrapper o1, wrapper o2) {
		DigitalVideoDisc mid = o1.tmp;
		o1.tmp = o2.tmp;
		o2.tmp = mid;
	}
}

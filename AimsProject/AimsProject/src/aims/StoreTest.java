package aims;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Title1", "Type1", "Name1", 80, 19.95f);
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Title2", "Type2", "Name2", 80, 19.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Title3", "Type3", "Name3", 80);
		store.addDVD(dvd1,  dvd3);
		
		store.removeDVD(dvd2);
	}

}

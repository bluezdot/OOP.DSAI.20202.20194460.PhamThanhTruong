/*package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {

	// All show menu method
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("STORE: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void cartMenu() {
		System.out.println("CART: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	public static void updateMenu() {
		System.out.println("UPDATE: ");
		System.out.println("-----------------------------------------");
		System.out.println("1. Add media");
		System.out.println("2. Remove media");
		System.out.println("0. Back");
		System.out.println("-----------------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void filterMenu() {
		System.out.println("FILTER: ");
		System.out.println("--------------------------------");
		System.out.println("1. By ID");
		System.out.println("2. By title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void sortMenu() {
		System.out.println("SORT: ");
		System.out.println("-----------------------------------------");
		System.out.println("1. By Title");
		System.out.println("2. By Cost");
		System.out.println("0. Back");
		System.out.println("-----------------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	// All choice actions 
	public static void actionShowMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		int inputMenu = sc.nextInt();
	
		// 1. View store
		if (inputMenu == 1)
		{
			for(Media m: store.itemsInStore) System.out.println(m.toString());
			System.out.println("-----------------------------------------");
			storeMenu();
			actionStoreMenu(store, cart);
		}
		
		// 2. Update store
		else if (inputMenu == 2)
		{
			updateMenu();
			actionUpdateMenu(store, cart);
		}
		
		// 3. See current cart
		else if (inputMenu == 3)
		{
			for(Media m: cart.getItemsOrdered()) System.out.println(m.toString());
			cartMenu();
			actionCartMenu(store, cart);
		}
		
		// 0. Exit
		else if (inputMenu == 0)
		{
			System.exit(0);
		}
	}
	public static void actionStoreMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		int inputStore = sc.nextInt();
		
		// 1. See details
		if (inputStore == 1) {
			store.print();
			System.out.println("Choose DVD's ID to view");
			int id = sc.nextInt();
			for (Media m: store.itemsInStore) {
				if (m.getId() == id) {
					m.getTitle();
				}
			}
			System.out.println("Do you want to add this media to cart ? 1.Yes --- 2.No");
			int n = sc.nextInt();
			if (n==1) {
				actionStore1Yes(id, store, cart);
			} 
			else if (n==2) {
				actionStore1No(id, store, cart);
			}
			
			storeMenu();
			actionStoreMenu(store, cart);
		}
		
		// 2. Add a media to cart
		else if (inputStore == 2) {
			
		}
		
		// 3. Play a media
		else if (inputStore == 3) {
			
		}
		
		// 4. See current cart
		else if (inputStore == 4) {
			
		}
		
		// 0. Back to showMenu
		else if (inputStore == 0) {
			showMenu();
			actionShowMenu(store, cart);
		}
		
	}
	public static void actionCartMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		int inputStore = sc.nextInt();
		
		// 1. Filter medias in cart
		if (inputStore == 1) {
			
		}
		
		// 2. Sort medias in cart
		if (inputStore == 2) {
			
		}
		
		// 3. Remove media from cart
		if (inputStore == 3) {
			
		}

		// 4. Play a media
		if (inputStore == 4) {
	
		}		
		// 5. Place order
		if (inputStore == 5) {
	
		}

		// 0. Back to storeMenu
		if (inputStore == 0) {
			storeMenu();
			actionStoreMenu(store, cart);
		}
	}
	public static void actionUpdateMenu(Store store, Cart cart) {
	
	}
	public static void actionStore1Yes(int id, Store store, Cart cart) {
		
	}
	public static void actionStore1No((int id, Store store, Cart cart){
		
	}
	
	// Main
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		CompactDisc cd = new CompactDisc("Title1", "Artist1");
		showMenu();
		actionShowMenu(store, cart);
	}
}*/

package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void main(String[] args) throws LimitExceededException, PlayerException {

		// Initialization
		Book book1 = new Book(1, "Title3", "Cat1", 100, "Kaka");
		Book book2 = new Book(2, "Title2", "Cat2", 80, "Kaka");
		Media dvd1 = new DigitalVideoDisc("DVD1", "LA", "123", 500);
		Media dvd2 = new DigitalVideoDisc("DVD1", "Mi", "123", 400);
		CompactDisc cd2 = new CompactDisc("CD2", "Cate2", 100, "Girl");
		CompactDisc cd1 = new CompactDisc("CD1", "Cate1", 100, "Man");


		Scanner sc = new Scanner(System.in);
		ArrayList<Media> ArrayListMedia = new ArrayList<Media>();
		ArrayList<Media> ArrayListMedia1 = new ArrayList<Media>();

		ArrayListMedia.add(book1);
		ArrayListMedia.add(book2);
		ArrayListMedia.add(dvd1);
		ArrayListMedia.add(dvd2);
		ArrayListMedia.add(cd1);
		ArrayListMedia.add(cd2);

		// Add all medias to Shop
		Store shop = new Store();
		for (Media m : ArrayListMedia) {
			shop.addMedia(m);
		}

		Cart cart = new Cart();
		
		// Start show main menu
		while (true) {

			showMenu();

			int inputMenu;
			inputMenu = sc.nextInt();

			{

				if (inputMenu == 1) {

					while (true) // while true of storeMenu
					{

						storeMenu();
						int inputStore;
						inputStore = sc.nextInt();

						if (inputStore == 1) {
							shop.print();
							// storeMenu();
						}

						else if (inputStore == 2) {
							System.out.println("Please input title");
							String inputTitle;
							inputTitle = sc.next();
							sc.nextLine();
							System.out.println("Do you want to put Media into Cart: Press '1' Yes/ '2' No");
							int customerChoice;
							customerChoice = sc.nextInt();
							int count = 0;
							if (customerChoice == 1) {

								for (Media m : ArrayListMedia) {
									if (m.getTitle().compareTo(inputTitle) == 0) {

										cart.addMedia(m);
										ArrayListMedia1.add(m);

									} else
										count++;

								}

								if (count == ArrayListMedia.size()) {
									System.out.println("The Media is not available");

								}

							}

						}

						else if (inputStore == 3) {

							System.out.println("Please input title");
							String inputTitle;
							inputTitle = sc.next();
							sc.nextLine();
							int count = 0;
							for (Media m : ArrayListMedia) {
								if (m.getTitle().compareTo(inputTitle) == 0) {
									String check = m.getClass().getName();

									check = check.substring(27, check.length());

									String nameDVD = "DigitalVideoDisc";
									String nameCD = "CompactDisc";
									String nameBook = "Book";

									if (check.compareTo(nameDVD) == 0) {
										System.out.println("here DVD");
										((DigitalVideoDisc) m).play();
										
										System.out.println("Do you want to put Media into Cart: Press '1' Yes/ '2' No");
										int customerChoice1;
										customerChoice1 = sc.nextInt();
										if (customerChoice1 == 1) {
											ArrayListMedia1.add(m);
											cart.addMedia(m);
										}

										break;
									}

									else if (check.compareTo(nameCD) == 0) {
										System.out.println("here CD");
										((CompactDisc) m).play();
										System.out.println("Do you want to put Media into Cart: Press '1' Yes/ '2' No");
										int customerChoice1;
										customerChoice1 = sc.nextInt();
										if (customerChoice1 == 1) {
											ArrayListMedia1.add(m);
											cart.addMedia(m);
										}
										
										break;
									} else if (check.compareTo(nameBook) == 0) {
										System.out.println("The Media can not play");
										System.out.println("Do you want to put Media into Cart: Press '1' Yes/ '2' No");
										int customerChoice1;
										customerChoice1 = sc.nextInt();
										if (customerChoice1 == 1) {
											ArrayListMedia1.add(m);
											cart.addMedia(m);
										}
										break;
									}

								} else {
									count++;
									if (count == ArrayListMedia.size())
										System.out.println("The Media is not available");

								}
							}

							
						}

						else if (inputStore == 4) {
							cart.print();
						}

						if (inputStore == 0)
							break;

					}
					// Done StoreMenu
				}

				else if (inputMenu == 2) {

					System.out.println("Press 1 to Add / 2 to Remove ");
					int choice;
					choice = sc.nextInt();

					if (choice == 1) // Add
					{
						System.out.println("Choose media type to add: ");
						System.out.println("1. CD --- 2.DVD --- 3.Book ");
						int type = sc.nextInt();
						if (type == 1) {
							System.out.println("Input Title, Category");
							CompactDisc newcd = new CompactDisc(sc.next(), sc.next());
							ArrayListMedia.add(newcd);
							shop.addMedia((CompactDisc) newcd);
							System.out.println("Added Successfully !");
						} else if (type == 2) {
							System.out.println("Input Title, Category, Cost");
							DigitalVideoDisc newdvd = new DigitalVideoDisc(sc.next(), sc.next(), sc.nextFloat());
							ArrayListMedia.add(newdvd);
							shop.addMedia((DigitalVideoDisc) newdvd);
							System.out.println("Added Successfully !");
						} else if (type == 3) {
							System.out.println("Input Id, Title, Category, Cost, Author");
							Book newbook = new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextFloat(), sc.next());
							ArrayListMedia.add(newbook);
							shop.addMedia(newbook);
							System.out.println("Added Successfully !");
						}

					}

					else // Remove
					{
						shop.print();
						int idGet;
						System.out.println("Please enter your ID of Media");
						idGet = sc.nextInt();
						int i = 0;
						for (Media m : ArrayListMedia) {
							if (m.getId() == idGet) {

								shop.removeMedia(m);
							} else {
								i++;
							}
						}
						if (i == ArrayListMedia.size()) {
							System.out.println("The media is not in store");
						}

					}

				}
				// Done 2. in showMenu

				else if (inputMenu == 3) {

					cart.print();
					while (true) {

						cartMenu();
						int choiceCartMenu;
						choiceCartMenu = sc.nextInt();

						if (choiceCartMenu == 1) {
							System.out.println("Do you want to filter by id or by title: 1/Id - 2/Title");
							int get;
							get = sc.nextInt();

							if (get == 1) {
								int idGet;
								System.out.println("Please enter your ID of Media");
								idGet = sc.nextInt();
								int i = 0;
								for (Media m : cart.getItemsOrdered()) {

									if (m.getId() == idGet) {
										System.out.println(m.toString());
									}

									else {
										i++;
									}

								}
								if (i == cart.getItemsOrdered().size()) {
									System.out.println("The media is not in Cart");
								}

							} else {
								sc.nextLine();
								System.out.println("Please enter Title:");
								String titleString;
								titleString = sc.nextLine();
								int i = 0;
								for (Media m : cart.getItemsOrdered()) {
									if (m.getTitle().compareTo(titleString) == 0) {
										System.out.println(m.toString());
										System.out.println("successful!");
									}
								}
								if (i == cart.getItemsOrdered().size()) {
									System.out.println("The media is not in Cart");
								}
							}
						} else if (choiceCartMenu == 2) {
							System.out.println("1/ Sort by Title - 2/Sort by totalCost");
							int choiceSort;
							choiceSort = sc.nextInt();
							if (choiceSort == 1) {
								java.util.Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
								cart.print();
							} else {
								java.util.Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
								cart.print();

							}
						}

						else if (choiceCartMenu == 3) {
							System.out.println("Enter your Title you want to remove");
							String titleRemove;
							sc.nextLine();
							titleRemove = sc.nextLine();

							for (Media m : ArrayListMedia1) {
								if (m.getTitle().compareTo(titleRemove) == 0) {
									// ArrayListMedia1.remove(m);
									cart.removeMedia(m);
									System.out.println("Remove successful");
								}
							}
							cart.print();

						}

						else if (choiceCartMenu == 4) {
							System.out.println("Enter your Title you want to play");
							String titlePlay;
							sc.nextLine();
							titlePlay = sc.nextLine();

							int count = 0;
							for (Media m : cart.getItemsOrdered()) {
								if (m.getTitle().compareTo(titlePlay) == 0) {
									String check = m.getClass().getName();

									check = check.substring(27, check.length());

									// System.out.println(check);
									String nameDVD = "DigitalVideoDisc";
									String nameCD = "CompactDisc";
									String nameBook = "Book";

									if (check.compareTo(nameDVD) == 0) {
										System.out.println("here DVD");
										((DigitalVideoDisc) m).play();

										break;
									}

									else if (check.compareTo(nameCD) == 0) {
										System.out.println("here CD");
										((CompactDisc) m).play();
										break;
									} else if (check.compareTo(nameBook) == 0) {
										System.out.println("The Media can not play");
										break;
									}

								} else {
									count++;
									if (count == ArrayListMedia.size())
										System.out.println("The Media is not available");

								}
							}

						} else if (choiceCartMenu == 5) {
							System.out.println("This is your current cart");
							cart.print();
							System.out.println("-------------------------");
							while (true) {
								;
								System.out.println("Input your information: Phone, Address");
								String phone = sc.next();
								sc.nextLine();
								String address = sc.nextLine();
								System.out.println("Your phone: " + phone);
								System.out.println("Your address: " + address);
								System.out.println("Total cost: " + cart.totalCost());
								System.out.println("Please confirm ! 1. Yes -- 2. No");
								int confirm = sc.nextInt();
								if (confirm == 1) {
									// Remove all media from Cart
									for (Media m : ArrayListMedia1) {

//										ArrayListMedia1.add(m);
										cart.removeMedia(m);
									}
									System.out.println("Your order is successful !");
									break;
								} else if (confirm == 2) {
									continue;
								}
							}

						}

						if (choiceCartMenu == 0)
							break;

					}

				}

			}

			if (inputMenu == 0)
				System.exit(0);

		}

	}
}

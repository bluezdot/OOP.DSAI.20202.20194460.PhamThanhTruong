package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}

		return center;
	}
	
	// MediaStore
	public class MediaStore extends JPanel{
		private Media media;
		public MediaStore(Media media) {
			
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel(""+media.getCost()+" $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));

			//Create action
			ButtonListener btnListener = new ButtonListener();
			JButton btn1 = new JButton("Add to cart");
			container.add(btn1);
			btn1.addActionListener(btnListener);
			
			if (media instanceof Playable) {
				JButton btn2 = new JButton("Play");
				container.add(btn2);
				btn2.addActionListener(btnListener);
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
		}
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add to cart")) {
				cart.addMedia()
				JDialog dialog = new JDialog();
				
				
			}
			else if (button.equals("Play")) {
				JDialog dialog = new JDialog();
				
			}
		}
	}
	
	public StoreScreen(Store store) {
		this.store = store;
		
		// Adding button actions
		
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		// Adding close application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	

	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion","Animation","Roger Allers",87,19.95f);
		store.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		store.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		store.addMedia(dvd3);
		Book b = new Book(1, "Harry Porter", "Action" ,35.5f, "La");
		store.addMedia(b);
		CompactDisc cd = new CompactDisc("Lalisa", "Comedy", 123, "Truong");
		store.addMedia(cd);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Girl From Nowhere","Drama",18.99f);
		store.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Old Dad","Drama",18.99f);
		store.addMedia(dvd5);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Black Widow","Science Fiction",18.99f);
		store.addMedia(dvd6);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Tom & Jerry","Animation",18.99f);
		store.addMedia(dvd7);
		new StoreScreen(store);

	}
}

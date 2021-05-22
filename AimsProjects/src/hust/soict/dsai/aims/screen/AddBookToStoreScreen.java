package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;


public class AddBookToStoreScreen extends JFrame{
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfCost;
	private Float costInField;
	private String titleInField;
	private String categoryInField;
	private Store store;
	private JTextField tfAuthors;
	private String authorsInField;
	

	public AddBookToStoreScreen(Store store) {
		// TODO Auto-generated constructor stub
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5, 2));
		
		cp.add(new JLabel("Enter title: "));
		
		tfTitle = new JTextField(40);
		cp.add(tfTitle);
		tfTitle.addActionListener(new TFTitleListener());
		
		cp.add(new JLabel("Enter category: "));
		
		tfCategory = new JTextField(40);
		cp.add(tfCategory);
		tfCategory.addActionListener(new TFcategoryListener());
		
		cp.add(new JLabel("Enter cost: "));
		
		tfCost = new JTextField(40);
		cp.add(tfCost);
		tfCost.addActionListener(new TFCostListener());
		
		cp.add(new JLabel("Enter authors with format {author1, author2,...}: "));
		
		tfAuthors = new JTextField(40);
		cp.add(tfAuthors);
		tfAuthors.addActionListener(new TFAuthorsListener());
		
		setTitle("Swing Accumulator");
		setSize(600, 200);
		setVisible(true);
		
		JButton Add = new JButton("Add");
		cp.add(Add, BorderLayout.NORTH);
		Add.addActionListener(new AddListener());
		
		this.store = store;


	}
	private class TFTitleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			titleInField = tfTitle.getText();
			tfTitle.setText("");

		}
	}
	
	private class TFCostListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			costInField = Float.parseFloat(tfCost.getText());
			tfCost.setText("");

		}
	}
	
	private class TFcategoryListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			categoryInField = tfCategory.getText();
			tfCategory.setText("");
		}
	}

	private class TFAuthorsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			authorsInField = tfAuthors.getText();
			
			tfAuthors.setText("");
		}
	}
	
	private class AddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			Book book = new Book(titleInField, categoryInField, costInField);
			if (authorsInField != null) {
	 			String[] authors = authorsInField.split(", ");
				for (String author: authors) {
					book.addAuthor(author);
				}
			}
			store.addMedia(book);
			dispose();
			new StoreScreen(store);
		}
	}
	
	

}

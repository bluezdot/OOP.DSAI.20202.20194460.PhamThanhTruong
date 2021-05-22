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

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfCost;
	private JTextField tfDirector;
	private JTextField tfLength;
	private float costInField;
	private String titleInField;
	private String categoryInField;
	private int lenghInField;
	private String directorInField;
	private Store store;

	public AddDigitalVideoDiscToStoreScreen(Store store) {
		// TODO Auto-generated constructor stub
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(6, 2));

		cp.add(new JLabel("Enter title: "));

		tfTitle = new JTextField(40);
		cp.add(tfTitle);
		tfTitle.addActionListener(new TFTitleListener());

		cp.add(new JLabel("Enter category: "));

		tfCategory = new JTextField(40);
		cp.add(tfCategory);
		tfCategory.addActionListener(new TFcategoryListener());

		cp.add(new JLabel("Enter director: "));

		tfDirector = new JTextField(40);
		cp.add(tfDirector);
		tfDirector.addActionListener(new TFDirectorListener());

		cp.add(new JLabel("Enter length: "));

		tfLength = new JTextField(40);
		cp.add(tfLength);
		tfLength.addActionListener(new TFLengthListener());

		cp.add(new JLabel("Enter cost: "));

		tfCost = new JTextField(40);
		cp.add(tfCost);
		tfCost.addActionListener(new TFCostListener());

		setTitle("Swing Accumulator");
		setSize(400, 300);
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

	private class TFcategoryListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			categoryInField = tfCategory.getText();
			tfCategory.setText("");
		}
	}

	private class TFDirectorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			directorInField = tfDirector.getText();
			tfDirector.setText("");
		}
	}

	private class TFLengthListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			lenghInField = Integer.parseInt(tfLength.getText());
			tfLength.setText("");
		}
	}

	private class TFCostListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			costInField = Float.parseFloat(tfCost.getText());
			tfCost.setText("");

		}
	}

	private class AddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			store.addMedia(
					new DigitalVideoDisc(titleInField, categoryInField, directorInField, lenghInField, costInField));
			dispose();
			new StoreScreen(store);
		}
	}

}

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

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame {
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfCost;
	private JTextField tfArtist;
	private Float costInField;
	private String titleInField;
	private String categoryInField;
	private Store store;
	private JTextField tfTracks;
	private String inputTracks;
	private String artistInField;

	public AddCompactDiscToStoreScreen(Store store) {
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

		cp.add(new JLabel("Enter artist: "));

		tfArtist = new JTextField(40);
		cp.add(tfArtist);
		tfArtist.addActionListener(new TFArtistListener());

		cp.add(new JLabel("Enter cost: "));

		tfCost = new JTextField(40);
		cp.add(tfCost);
		tfCost.addActionListener(new TFCostListener());

		cp.add(new JLabel("Enter tracks (track1 - length, track2 - length,...): "));

		tfTracks = new JTextField(100);
		cp.add(tfTracks);
		tfTracks.addActionListener(new TFTracksListener());

		setTitle("Swing Accumulator");
		setSize(1000, 200);
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

	private class TFArtistListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			artistInField = tfArtist.getText();
			tfArtist.setText("");
		}
	}

	private class TFTracksListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			inputTracks = tfTracks.getText();
			tfTracks.setText("");

		}
	}

	private class AddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			CompactDisc cd = new CompactDisc(titleInField, categoryInField, costInField, artistInField);
			String[] Tracks = inputTracks.split(", ");
			for (String track : Tracks) {
				String[] info = track.split(" - ");
				cd.addTrack(new Track(info[0], Integer.parseInt(info[1])));
			}
			store.addMedia(cd);
			dispose();
			new StoreScreen(store);
		}
	}

}

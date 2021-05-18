package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;


// MediaStore
public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	
	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public MediaStore(Media media, Cart cart) {
		
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton btnAdd = new JButton("Add to cart");
        btnAdd.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
    			// Show dialog
				JDialog dlAdd = new JDialog();
	    		dlAdd.setBounds(ABORT, ABORT, WIDTH, HEIGHT);;
	    		dlAdd.setTitle("Status");
	    		
	    		JLabel lAdd = new JLabel(" Media has already added !");
	    		
	    		dlAdd.add(lAdd);
	    		dlAdd.setSize(200, 150);
	    		dlAdd.setVisible(true);

	    		// Add to cart
	    		cart.addMedia(media);
        	}
        });
        container.add(btnAdd);
		
		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(new ActionListener() {
            	@Override
            	public void actionPerformed(ActionEvent e) {
            		JLabel playMessage = new JLabel("Playing...");
            				
            		try {
                		((Playable) media).play();
            		} catch (Exception ex) {
            			playMessage = new JLabel(ex.getMessage());
            		}

        			// Show dialog
            		JDialog dlPlay = new JDialog();
            		dlPlay.setBounds(ABORT, ABORT, WIDTH, HEIGHT);
            		dlPlay.setTitle(media.getTitle());
	
            		dlPlay.add(playMessage);
            		dlPlay.pack();
            		
            		dlPlay.setVisible(true);
            		dlPlay.setSize(400,200);

            	}
            });
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
}
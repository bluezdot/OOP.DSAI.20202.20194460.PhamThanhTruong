package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
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
                try {
                    cart.addMedia(media);
                } catch (LimitExceededException limitExceededException) {
                    limitExceededException.printStackTrace();
                }


            }
        });
        container.add(btnAdd);
		
		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(new ActionListener() {
            	@Override
            	public void actionPerformed(ActionEvent e) {
                    try{
                        ((Playable) media).play();
                    } catch (PlayerException playerException) {
                        new ErrorDialogStore(playerException);
                    }

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
	
	public class ErrorDialogStore {
	    public ErrorDialogStore(PlayerException e){
	        Frame frame = new Frame();
	        JOptionPane.showMessageDialog(frame,"Error: Media Length is non-positive!!!", "Illegal for Media Length", JOptionPane.ERROR_MESSAGE );

	    }
	}
}
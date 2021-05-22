package hust.soict.dsai.aims.screen;


import java.awt.BorderLayout;
import java.awt.ComponentOrientation;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	private Store store;
	
    @FXML
    private Button btnPlay;
    
    @FXML
    private Button btnRemove;
    
    @FXML
    private ToggleGroup filterCatagory;
    
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
	private TextField tfFilter;
	
	@FXML
	private RadioButton radioBtnFilterId;
	
	@FXML
	private RadioButton radioBtnFilterTitle;
	
    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Label lbTotalCost;
    
    @FXML
    private MenuItem btnAddDVD;
    
    @FXML
    private MenuItem btnAddBook;
    
    @FXML
    private MenuItem btnAddCD;
    
    @FXML
    private MenuItem btnViewStore;
    
	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		
		//get item in listMedia
		ObservableList<Media> listMedia = this.cart.getItemsOrdered();
		tblMedia.setItems(listMedia);
		lbTotalCost.setText("" + cart.totalCost() + "$");
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue <? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}
				});
		
		// Add filter
		tfFilter.textProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue <? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	// Remove button
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		lbTotalCost.setText("" + cart.totalCost() + "$");
	}
	
	// Play button
	@FXML
    void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		
		JTextPane tfDisplay = new JTextPane();
		JFrame play = new JFrame();
		JDialog playMedia = new JDialog(play, "Play Demo");
		
		tfDisplay.setText("Playing DVD: " + media.getTitle());
		tfDisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		playMedia.setSize(400, 400);
		playMedia.add(tfDisplay, BorderLayout.CENTER);
		playMedia.setVisible(true);

    }
	
	// Filter method
	void showFilteredMedia(String newValue) {
        FilteredList<Media> filterData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        filterData.setPredicate(media -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String newValueLower = newValue.toLowerCase();

            if (radioBtnFilterTitle.isSelected()) {
            	return media.getTitle().toLowerCase().contains(newValueLower);
            	
                
            } else if (radioBtnFilterId.isSelected()) {
            	int idSearch = Integer.parseInt(newValueLower);
            	return media.getId() == idSearch;
            }
            return false;
        });

        tblMedia.setItems(filterData);
    }
	
	// Place Order Button
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		
		if (cart.getItemsOrdered().size() == 0) {
			JTextPane tfDisplay = new JTextPane();
			tfDisplay.setText("There's no item in the cart !");
			
			JFrame orderStatus = new JFrame("Order status");
			JDialog order = new JDialog(orderStatus);
			order.setSize(400, 400);
			order.add(tfDisplay, BorderLayout.CENTER);
			order.setVisible(true);
		}
		
		else {
			JTextPane tfDisplay = new JTextPane();
			tfDisplay.setText("You have already place an order ! \nYour total cost is: " + cart.totalCost()+"$");
			
			cart.clearCart();
			lbTotalCost.setText("" + cart.totalCost());
			
			JFrame orderStatus = new JFrame("Order status");
			JDialog order = new JDialog(orderStatus);
			order.setSize(400, 400);
			order.add(tfDisplay, BorderLayout.CENTER);
			order.setVisible(true);
		}
	}
	
	// Option menu
	@FXML
	void btnViewStorePressed(ActionEvent event) {
		new StoreScreen(cart, store);
	}
	
	@FXML
	void btnAddBookPressed(ActionEvent event) {
		new AddBookToStoreScreen(store);
	}
	
	@FXML
	void btnAddDVDPressed(ActionEvent event) {
		new AddDigitalVideoDiscToStoreScreen(store);
	}
	
	@FXML
	void btnAddCDPressed(ActionEvent event) {
		new AddCompactDiscToStoreScreen(store);
	}
	
}


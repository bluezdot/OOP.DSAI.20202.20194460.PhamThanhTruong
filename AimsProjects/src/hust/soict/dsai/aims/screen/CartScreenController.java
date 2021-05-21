package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
//	private Store store;
	
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
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
//		this.store = store;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		
		//get item in listMedia
		ObservableList<Media> listMedia = this.cart.getItemsOrdered();
		tblMedia.setItems(listMedia);
		
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
	}
	
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
}


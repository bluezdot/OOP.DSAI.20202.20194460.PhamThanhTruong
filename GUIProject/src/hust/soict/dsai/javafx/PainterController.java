package hust.soict.dsai.javafx;

import java.awt.Button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private ToggleGroup tgTools;

    @FXML
    private RadioButton rbEraser;

    @FXML
    private RadioButton rbPen;
    
	@FXML
	private Pane drawingAreaPane;

	@FXML
    void drawingAreaMouseDragged(MouseEvent event) {
		if (rbPen.isSelected()) {
	    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK); 
	    	drawingAreaPane.getChildren().add(newCircle);
		}
		else if (rbEraser.isSelected()) {
			Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE); 
	    	drawingAreaPane.getChildren().add(newCircle);
		}
	}

	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();

	}

}



package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OmangementController {
	@FXML
	private ImageView i1;
	@FXML
	private ImageView i2;
	@FXML
	private ImageView i3;
	@FXML
	private ImageView i4;
	@FXML
	private ImageView i5;
	@FXML
	private Button i6;
	
	@FXML
	public void s6(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel this order?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
        }
        
	}
	public void initialize(String status) {
	    // Set the initial visibility and disable state
	    i2.setVisible(false);
	    i3.setVisible(false);
	    i4.setVisible(false);
	    i5.setVisible(false);
	    
	    // Update based on the status
	    switch (status) {
	        case "Packed":
	            i2.setVisible(true);
	            break;
	        case "Dispatch":
	            i2.setVisible(true);
	            i3.setVisible(true);
	            break;
	        case "Delivered":
	            i2.setVisible(true);
	            i3.setVisible(true);
	            i4.setVisible(true);
	            i6.setDisable(true);
	            break;
	        case "Cancelled":
	            i5.setVisible(true);
	            i6.setDisable(true);
	            break;
	        default:
	            // Handle other cases or provide a default behavior
	            break;
	    }
	}

	        }



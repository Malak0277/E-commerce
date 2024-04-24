package com.example.testingproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalTime;


import java.io.IOException;

public class OmangementController {

	@FXML
	private Button backBtn;
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

	
    private User user = EcomSystem.getCurrentSystem().getCurrentUser();

	@FXML
	public void s6(ActionEvent event) {
		String OrderID = Order.SelectedOrder.getOrderID();
		Order o = user.getOrder(OrderID);

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel this order?", ButtonType.YES, ButtonType.NO);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
			o.cancel_order();
			StatusSwitch(o.getStatus());
		}
	}

	@FXML
	void backBtnOnAction(ActionEvent event) {
		navigateTo(event, "OrdersList.fxml");
	}

	@FXML
	public void initialize() {
		LocalTime now = LocalTime.now();
		if(!Order.SelectedOrder.getStatus().equals("Cancelled"))
			Order.SelectedOrder.scheduleStatusUpdate(now);

		String status = Order.SelectedOrder.getStatus();

		// Set the initial visibility and disable state

		StatusSwitch(status);
		// Update based on the status

		backBtn.setOnAction(event -> backBtnOnAction(event));
	}


	public void navigateTo(ActionEvent event, String nextPageFXML) {
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader (getClass().getResource(nextPageFXML));
			root = loader.load();
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();}
		catch (IOException e) {}
	}

	public void StatusSwitch(String Status)
	{
		switch (Status) {
			case "Order_Placed":
				i2.setVisible(false);
				i3.setVisible(false);
				i4.setVisible(false);
				i5.setVisible(false);
				break;
			case "Packed":
				i2.setVisible(true);
				i3.setVisible(false);
				i4.setVisible(false);
				i5.setVisible(false);
				break;
			case "Dispatch":
				i2.setVisible(true);
				i3.setVisible(true);
				i4.setVisible(false);
				i5.setVisible(false);
				break;
			case "Delivered":
				i2.setVisible(true);
				i3.setVisible(true);
				i4.setVisible(true);
				i5.setVisible(false);
				i6.setDisable(true);
				break;
			case "Cancelled":
				i1.setVisible(false);
				i2.setVisible(false);
				i3.setVisible(false);
				i4.setVisible(false);
				i5.setVisible(true);
				i6.setDisable(true);
				break;
			default:
				break;
		}
	}

}
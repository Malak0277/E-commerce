package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
	            OrderHistory o1= new OrderHistory();
	            VBox vbox = new VBox();
	            for (int orderNumber = 1; orderNumber <=o1.getOrdersHistorysize() ; orderNumber++) {
	                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Omangement.fxml"));
	                Parent omangementContent = fxmlLoader.load();
	                
	                OmangementController controller = fxmlLoader.getController();
	                String orderStatus = o1.getOrder(orderNumber).getOrderStatus();
	                controller.initialize(orderStatus);
	                
	                vbox.getChildren().add(omangementContent);
	            }
	            // Wrap the VBox in a ScrollPane
	            ScrollPane scrollPane = new ScrollPane();
	            scrollPane.setContent(vbox);
	            scrollPane.setFitToWidth(true);
	            scrollPane.setFitToHeight(true);

	            Scene scene = new Scene(scrollPane, 600, 400); // Initial size
	            primaryStage.setTitle("History");
	            primaryStage.setScene(scene);
	            primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

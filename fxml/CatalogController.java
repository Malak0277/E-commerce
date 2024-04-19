import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.geometry.Insets;

public class CatalogController implements Initializable {

    @FXML
    private GridPane menu;

    Image image;
    ObservableList<Item> itemsList;


    //private ObservableList<Catalog> itemsList = FXCollections.observableArrayList();

    public ObservableList<Item> getItemsList() {
        /*
        while (not empty) {
            it = new Item(
                result.getString("prod_name"),
                result.getString("type"),
                result.getInt("stock"),
                result.getDouble("price"),
                result.getString("image"));
            itemsList.add(it);
        }
        */
        return itemsList;
    }

    public void menuDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());

        int row = 0;
        int column = 0;

        menu.getChildren().clear();
        menu.getRowConstraints().clear();
        menu.getColumnConstraints().clear();

        for (int q = 0; q < itemsList.size(); q++) {
            try {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("Item.fxml"));
                AnchorPane pane = load.load();
                ItemController itemCard = load.getController();
                itemCard.setData(itemsList.get(q));

                if (column == 3) {
                    column = 0;
                    row += 1;
                }

                menu.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        menuDisplay();

    }
}

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.geometry.Insets;

public class CatalogController implements Initializable {

    @FXML
    private GridPane adventure;

    @FXML
    private GridPane classic;

    @FXML
    private GridPane fiction;

    @FXML
    private GridPane history;

    @FXML
    private Label logout;

    @FXML
    private GridPane mystery;

    @FXML
    private Region navCart;

    @FXML
    private Region navHome;

    @FXML
    private GridPane romance;

    @FXML
    private GridPane science;

    @FXML
    private VBox sideNav;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
    private Tab tab5;

    @FXML
    private Tab tab6;

    @FXML
    private Tab tab7;

    private ObservableList<Item> itemsList = FXCollections.observableArrayList();

    public ObservableList<Item> getItemsList() {
        ObservableList<Item> currItemsList = FXCollections.observableArrayList(Catalog.getAllItems());
        return currItemsList;
    }


    public void classicDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());
        int row = 0, column = 0;

        classic.getChildren().clear();
        classic.getRowConstraints().clear();
        classic.getColumnConstraints().clear();

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

                classic.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void romanceDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());
        int row = 0, column = 0;

        romance.getChildren().clear();
        romance.getRowConstraints().clear();
        romance.getColumnConstraints().clear();

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

                romance.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void fictionDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());
        int row = 0, column = 0;

        fiction.getChildren().clear();
        fiction.getRowConstraints().clear();
        fiction.getColumnConstraints().clear();

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

                fiction.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void adventureDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());
        int row = 0, column = 0;

        adventure.getChildren().clear();
        adventure.getRowConstraints().clear();
        adventure.getColumnConstraints().clear();

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

                adventure.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void mysteryDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());
        int row = 0, column = 0;

        mystery.getChildren().clear();
        mystery.getRowConstraints().clear();
        mystery.getColumnConstraints().clear();

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

                mystery.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void historyDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());
        int row = 0, column = 0;

        history.getChildren().clear();
        history.getRowConstraints().clear();
        history.getColumnConstraints().clear();

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

                history.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void scienceDisplay() {
        itemsList.clear();
        itemsList.addAll(getItemsList());
        int row = 0, column = 0;

        science.getChildren().clear();
        science.getRowConstraints().clear();
        science.getColumnConstraints().clear();

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

                science.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        classicDisplay();
        romanceDisplay();
        fictionDisplay();
        adventureDisplay();
        mysteryDisplay();
        historyDisplay();
        scienceDisplay();

    }
}

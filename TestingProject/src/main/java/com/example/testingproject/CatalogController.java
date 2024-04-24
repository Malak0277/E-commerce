package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import javafx.stage.Stage;

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
    private Label orders;

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

    private GridPane grid;
    private Catalog currList;

    Catalog classicCatalog = new Catalog();
    Catalog romanceCatalog = new Catalog();
    Catalog fictionCatalog = new Catalog();
    Catalog adventureCatalog = new Catalog();
    Catalog mysteryCatalog = new Catalog();
    Catalog historyCatalog = new Catalog();
    Catalog scienceCatalog = new Catalog();

    public void dataStored() {
        classicCatalog.addItem(new Item("The Great Gatsby", "Classic", 10.99, 20, "great_gatsby.jpg"));
        classicCatalog.addItem(new Item("Pride and Prejudice", "Classic", 8.50, 15, "pride_prejudice.jpg"));
        classicCatalog.addItem(new Item("To Kill a Mockingbird", "Classic", 9.25, 12, "to_kill_a_mockingbird.jpg"));
        classicCatalog.addItem(new Item("The Catcher in the Rye", "Classic", 11.25, 15, "catcher_in_the_rye.jpg"));
        classicCatalog.addItem(new Item("The Odyssey", "Classic", 10.50, 18, "odyssey.jpg"));
        classicCatalog.addItem(new Item("Jane Eyre", "Classic", 9.75, 18, "jane_eyre.jpg"));
        classicCatalog.addItem(new Item("Moby-Dick", "Classic", 11.99, 20, "moby_dick.jpg"));
        classicCatalog.addItem(new Item("War and Peace", "Classic", 15.25, 25, "war_and_peace.jpg"));
        classicCatalog.addItem(new Item("The Picture of Dorian Gray", "Classic", 10.50, 15, "dorian_gray.jpg"));
        classicCatalog.addItem(new Item("Wuthering Heights", "Classic", 8.99, 22, "wuthering_heights.jpg"));

        romanceCatalog.addItem(new Item("Sense and Sensibility", "Romance", 8.25, 18, "sense_and_sensibility.jpg"));
        romanceCatalog.addItem(new Item("Emma", "Romance", 9.50, 20, "emma.jpg"));
        romanceCatalog.addItem(new Item("The Notebook", "Romance", 7.25, 15, "notebook.jpg"));
        romanceCatalog.addItem(new Item("Gone with the Wind", "Romance", 12.99, 25, "gone_with_the_wind.jpg"));
        romanceCatalog.addItem(new Item("P.S. I Love You", "Romance", 8.99, 22, "ps_i_love_you.jpg"));
        romanceCatalog.addItem(new Item("Pride and Prejudice", "Romance", 8.50, 15, "pride_prejudice.jpg"));
        romanceCatalog.addItem(new Item("Romeo and Juliet", "Romance", 7.99, 20, "romeo_juliet.jpg"));
        romanceCatalog.addItem(new Item("Twilight", "Romance", 7.75, 25, "twilight.jpg"));

        fictionCatalog.addItem(new Item("1984", "Fiction", 12.75, 30, "1984.jpg"));
        fictionCatalog.addItem(new Item("Brave New World", "Fiction", 10.99, 18, "brave_new_world.jpg"));
        fictionCatalog.addItem(new Item("The Catch-22", "Fiction", 9.75, 20, "catch_22.jpg"));
        fictionCatalog.addItem(new Item("The Alchemist", "Fiction", 11.50, 15, "alchemist.jpg"));
        fictionCatalog.addItem(new Item("The Road", "Fiction", 8.99, 22, "the_road.jpg"));
        fictionCatalog.addItem(new Item("The Kite Runner", "Fiction", 10.25, 25, "kite_runner.jpg"));

        adventureCatalog.addItem(new Item("Treasure Island", "Adventure", 7.99, 18, "treasure_island.jpg"));
        adventureCatalog.addItem(new Item("Journey to the Center of the Earth", "Adventure", 8.50, 20, "journey_to_the_center.jpg"));
        adventureCatalog.addItem(new Item("The Count of Monte Cristo", "Adventure", 12.75, 15, "count_of_monte_cristo.jpg"));
        adventureCatalog.addItem(new Item("Around the World in Eighty Days", "Adventure", 9.99, 22, "around_the_world.jpg"));
        adventureCatalog.addItem(new Item("The Adventures of Tom Sawyer", "Adventure", 7.25, 25, "tom_sawyer.jpg"));
        adventureCatalog.addItem(new Item("The Hobbit", "Adventure", 9.99, 25, "hobbit.jpg"));
        adventureCatalog.addItem(new Item("Harry Potter and the Sorcerer's Stone", "Adventure", 11.50, 28, "harry_potter_sorcerers_stone.jpg"));
        adventureCatalog.addItem(new Item("Jurassic Park", "Adventure", 9.99, 20, "jurassic_park.jpg"));
        adventureCatalog.addItem(new Item("The Hunger Games", "Adventure", 8.99, 30, "hunger_games.jpg"));

        mysteryCatalog.addItem(new Item("The Da Vinci Code", "Mystery", 11.25, 18, "da_vinci_code.jpg"));
        mysteryCatalog.addItem(new Item("The Girl with the Dragon Tattoo", "Mystery", 10.75, 16, "girl_with_dragon_tattoo.jpg"));
        mysteryCatalog.addItem(new Item("Gone Girl", "Mystery", 13.25, 22, "gone_girl.jpg"));
        mysteryCatalog.addItem(new Item("And Then There Were None", "Mystery", 8.99, 18, "and_then_there_were_none.jpg"));
        mysteryCatalog.addItem(new Item("The Hound of the Baskervilles", "Mystery", 9.50, 20, "hound_of_baskervilles.jpg"));
        mysteryCatalog.addItem(new Item("In Cold Blood", "Mystery", 11.75, 15, "in_cold_blood.jpg"));
        mysteryCatalog.addItem(new Item("The Silence of the Lambs", "Mystery", 10.99, 22, "silence_of_the_lambs.jpg"));
        mysteryCatalog.addItem(new Item("The Big Sleep", "Mystery", 8.25, 25, "big_sleep.jpg"));

        historyCatalog.addItem(new Item("The Rise and Fall of the Third Reich", "History", 16.99, 18, "rise_and_fall.jpg"));
        historyCatalog.addItem(new Item("1491: New Revelations of the Americas Before Columbus", "History", 13.50, 20, "1491.jpg"));
        historyCatalog.addItem(new Item("Band of Brothers", "History", 11.75, 15, "band_of_brothers.jpg"));
        historyCatalog.addItem(new Item("1776", "History", 12.99, 22, "1776.jpg"));
        historyCatalog.addItem(new Item("The Wright Brothers", "History", 10.25, 25, "wright_brothers.jpg"));
        historyCatalog.addItem(new Item("The Guns of August", "History", 14.50, 10, "guns_of_august.jpg"));
        historyCatalog.addItem(new Item("The Art of War", "History", 12.99, 14, "art_of_war.jpg"));

        scienceCatalog.addItem(new Item("A Brief History of Time", "Science", 13.49, 22, "brief_history_of_time.jpg"));
        scienceCatalog.addItem(new Item("The Martian", "Science", 12.99, 20, "martian.jpg"));
        scienceCatalog.addItem(new Item("Sapiens: A Brief History of Humankind", "Science", 14.25, 18, "sapiens.jpg"));
        scienceCatalog.addItem(new Item("Astrophysics for People in a Hurry", "Science", 11.50, 20, "astrophysics.jpg"));
        scienceCatalog.addItem(new Item("The Selfish Gene", "Science", 10.99, 15, "selfish_gene.jpg"));
        scienceCatalog.addItem(new Item("Cosmos", "Science", 13.75, 22, "cosmos.jpg"));
        scienceCatalog.addItem(new Item("The Double Helix", "Science", 9.25, 25, "double_helix.jpg"));
    }


    public void display(String name) {
        int row = 0, column = 0;

        switch (name) {
            case "classic":
                currList = classicCatalog;
                grid = classic;
                break;
            case "romance":
                currList = romanceCatalog;
                grid = romance;
                break;
            case "fiction":
                currList = fictionCatalog;
                grid = fiction;
                break;
            case "adventure":
                currList = adventureCatalog;
                grid = adventure;
                break;
            case "mystery":
                currList = mysteryCatalog;
                grid = mystery;
                break;
            case "history":
                currList = historyCatalog;
                grid = history;
                break;
            case "science":
                currList = scienceCatalog;
                grid = science;
                break;
            default:
                System.out.println("error calling display function in catalog controller");
        }

        grid.getChildren().clear();
        grid.getRowConstraints().clear();
        grid.getColumnConstraints().clear();


        try {
            for (int i = 0; i < currList.size(); i++) {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("Item.fxml"));
                AnchorPane pane = load.load();
                ItemController card = load.getController();
                card.setData(currList.getAllItems().get(i));

                if (column == 3) {
                    column = 0;
                    row += 1;
                }

                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(8));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleNavCartClick(MouseEvent event) {
        navigateTo(event, "Cart.fxml");
    }

    @FXML
    private void handleLogoutClick(MouseEvent event) {
        navigateTo(event, "login.fxml");
    }

    @FXML
    private void handleOrdersClick(MouseEvent event) {
        navigateTo(event, "OrdersList.fxml");
    }

    public void navigateTo(MouseEvent event, String nextPageFXML) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataStored();
        display("classic");
        display("romance");
        display("fiction");
        display("adventure");
        display("mystery");
        display("history");
        display("science");

        orders.setOnMouseClicked(this::handleOrdersClick);
        navCart.setOnMouseClicked(this::handleNavCartClick);
        logout.setOnMouseClicked(this::handleLogoutClick);

    }

}
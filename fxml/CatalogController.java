import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
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

        romanceCatalog.addItem(new Item("Pride and Prejudice", "Romance", 8.50, 15, "pride_prejudice.jpg"));
        romanceCatalog.addItem(new Item("Romeo and Juliet", "Romance", 7.99, 20, "romeo_juliet.jpg"));
        romanceCatalog.addItem(new Item("Twilight", "Romance", 7.75, 25, "twilight.jpg"));

        fictionCatalog.addItem(new Item("1984", "Fiction", 12.75, 30, "1984.jpg"));

        adventureCatalog.addItem(new Item("The Hobbit", "Adventure", 9.99, 25, "hobbit.jpg"));
        adventureCatalog.addItem(new Item("Harry Potter and the Sorcerer's Stone", "Adventure", 11.50, 28, "harry_potter_sorcerers_stone.jpg"));
        adventureCatalog.addItem(new Item("Jurassic Park", "Adventure", 9.99, 20, "jurassic_park.jpg"));
        adventureCatalog.addItem(new Item("The Hunger Games", "Adventure", 8.99, 30, "hunger_games.jpg"));

        mysteryCatalog.addItem(new Item("The Da Vinci Code", "Mystery", 11.25, 18, "da_vinci_code.jpg"));
        mysteryCatalog.addItem(new Item("The Girl with the Dragon Tattoo", "Mystery", 10.75, 16, "girl_with_dragon_tattoo.jpg"));
        mysteryCatalog.addItem(new Item("Gone Girl", "Mystery", 13.25, 22, "gone_girl.jpg"));

        historyCatalog.addItem(new Item("The Guns of August", "History", 14.50, 10, "guns_of_august.jpg"));
        historyCatalog.addItem(new Item("The Art of War", "History", 12.99, 14, "art_of_war.jpg"));

        scienceCatalog.addItem(new Item("A Brief History of Time", "Science", 13.49, 22, "brief_history_of_time.jpg"));
        scienceCatalog.addItem(new Item("The Martian", "Science", 12.99, 20, "martian.jpg"));
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
                GridPane.setMargin(pane, new Insets(10));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }
}
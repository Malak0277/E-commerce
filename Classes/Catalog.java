import java.util.ArrayList;

public class Catalog {
    private String name;
    private static ArrayList<Item> items;

    static {
        items.add(new Item("The Great Gatsby", "Classic", 10.99, 20, "great_gatsby.jpg"));
        items.add(new Item("Pride and Prejudice", "Romance", 8.50, 15, "pride_prejudice.jpg"));
        items.add(new Item("1984", "Fiction", 12.75, 30, "1984.jpg"));
        items.add(new Item("The Hobbit", "Adventure", 9.99, 25, "hobbit.jpg"));
        items.add(new Item("The Da Vinci Code", "Mystery", 11.25, 18, "da_vinci_code.jpg"));
        items.add(new Item("The Guns of August", "History", 14.50, 10, "guns_of_august.jpg"));
        items.add(new Item("A Brief History of Time", "Science", 13.49, 22, "brief_history_of_time.jpg"));
        items.add(new Item("To Kill a Mockingbird", "Classic", 9.25, 12, "to_kill_a_mockingbird.jpg"));
        items.add(new Item("Romeo and Juliet", "Romance", 7.99, 20, "romeo_juliet.jpg"));
        items.add(new Item("Harry Potter and the Sorcerer's Stone", "Adventure", 11.50, 28, "harry_potter_sorcerers_stone.jpg"));
        items.add(new Item("The Girl with the Dragon Tattoo", "Mystery", 10.75, 16, "girl_with_dragon_tattoo.jpg"));
        items.add(new Item("The Art of War", "History", 12.99, 14, "art_of_war.jpg"));
        items.add(new Item("Cosmos", "Science", 15.99, 18, "cosmos.jpg"));
        items.add(new Item("The Notebook", "Romance", 8.75, 10, "notebook.jpg"));
        items.add(new Item("The Catcher in the Rye", "Classic", 11.25, 15, "catcher_in_the_rye.jpg"));
        items.add(new Item("Jurassic Park", "Adventure", 9.99, 20, "jurassic_park.jpg"));
        items.add(new Item("Gone Girl", "Mystery", 13.25, 22, "gone_girl.jpg"));
        items.add(new Item("The Origin of Species", "Science", 14.99, 12, "origin_of_species.jpg"));
        items.add(new Item("The Odyssey", "Classic", 10.50, 18, "odyssey.jpg"));
        items.add(new Item("Twilight", "Romance", 7.75, 25, "twilight.jpg"));
        items.add(new Item("The Martian", "Science", 12.99, 20, "martian.jpg"));
        items.add(new Item("The Hunger Games", "Adventure", 8.99, 30, "hunger_games.jpg"));
        items.add(new Item("The Shining", "Horror", 11.75, 15, "shining.jpg"));
    }

    public Catalog() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(String bookName) {
        for (Item item : items)
            if (item.getName() == bookName)
                return item;
        return null;
    }

    public static ArrayList<Item> getAllItems() {
        return items;
    }

    public boolean isIn(String bookName) {
        for (Item item : items)
            if (item.getName() == bookName)
                return true;
        return false;
    }

    public ArrayList<Item> searchIn(String keyword) {
        ArrayList<Item> searchResults = new ArrayList<>();
        for (Item item : items)
            if (item.getName().toLowerCase().contains(keyword.toLowerCase()))
                searchResults.add(item);
        return searchResults;
    }

}

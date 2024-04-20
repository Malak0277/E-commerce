import java.util.ArrayList;

public class Catalog {
    private String name;
    private static ArrayList<Item> items;

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

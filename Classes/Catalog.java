import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Item> items;

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
        for (Item item : items) {
            if (item.getBookName() == bookName) {
                return item;
            }
        }
        return null; // Item not found
    }

    public List<Item> listItems() {
        return items;
    }

    public List<Item> searchItems(String keyword) {
        List<Item> searchResults = new ArrayList<>();
        for (Item item : items) {
            if (item.getBookName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

}

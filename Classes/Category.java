public class Category {
    private String name;
    private int id;

    public Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getname() {
        return this.name;
    }

    public int getid() {
        return this.id;
    }

    public void printCategory() {
        System.out.println("Category name: " + this.name);
        System.out.println("Category Id: " + this.id);
    }

}

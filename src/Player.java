import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private String description;
    private ArrayList<Item> items;
    private Graph.Node currentNode;

    public Player() {
        name = "No Name";
        description = "This player had no description";
        items = new ArrayList<>();

    }

    public Player(Graph.Node currentNode) {
        this.currentNode = currentNode;
        name = "No Name";
        description = "This player had no description";
        items = new ArrayList<>();
    }

    public Player(String name) {
        this.name = name;
        description = "This player had no description";
        items = new ArrayList<>();
    }

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        ;
    }

    public void addItem(Item item) {

        items.add(item);
    }

    public Item removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            String itemName = item.getName();
            if (itemName.equals(name)) {
                return items.remove(i);
            }
        }
        return null;

    }

    public boolean destroyItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            String itemName = item.getName();
            if (itemName.equals(name)) {
                items.remove(i);
                return true;
            }
        }
        return false;

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String displayItems() {

        String itemNames = "you have these items: ";
        for (Item item : items) {
            String itemName = item.getName();
            itemNames += itemName + ",";
        }
        return itemNames;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentNode(Graph.Node newNode) {
        this.currentNode = newNode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean moveToRoom(String name) {
        HashMap<String, Graph.Node> currentNodeNeighbors = currentNode.getNeighbors();
        if (currentNodeNeighbors.containsKey(name)) {
            currentNode = currentNodeNeighbors.get(name);
            return true;
        }
        return false;
    }

    public boolean moveToRoom(Graph.Node node) {
        if (node != null) {
            currentNode = node;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Graph.Node getCurrentNode() {
        return currentNode;
    }

    public boolean hasItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            String itemName = item.getName();
            if (itemName.equals(name)) {
                return true;
            }
        }
        return false;

    }
}

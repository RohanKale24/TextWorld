import java.util.HashMap;

public class Player {
    private String name;
    private String description;
    private HashMap<String, Item> items;
    private Graph.Node currentNode;

    public Player() {
        name = "No Name";
        description = "This player had no description";
        items = new HashMap<>();

    }

    public Player(String name) {
        this.name = name;
        description = "This player had no description";
        items = new HashMap<>();
    }

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new HashMap<>();
    }

    public void addItem(Item item) {
        String itemName = item.getName();
        items.put(itemName, item);
    }

    public Item removeItem(String name) {
        Item i = items.remove(name);
        return i;
    }

    public boolean destroyItem(String name) {
        if (items.containsKey(name)) {
            items.remove(name);
            return true;
        }
        return false;

    }

    public HashMap getItems() {
        return items;
    }

    public String displayItems() {

        String itemNames = "you have these items: ";
        for (String name : items.keySet()) {

            itemNames += name + ",";
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
        if (items.containsKey(name)) {
            return true;
        }
        return false;
    }
}

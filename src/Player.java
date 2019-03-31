import java.util.HashMap;

public class Player {
    String name;
    String description;
    HashMap<String, Item> items;
    Graph.Node currentNode;

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

    public void destroyItem(String name) {
        items.remove(name);
    }

    public HashMap getItems() {
        return items;
    }

    public void displayItems() {
        System.out.print("you have these items: ");
        for (String name : items.keySet()) {
            System.out.print(name + ",");
        }
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

    public boolean moveToRoom(String name){
        HashMap<String,Graph.Node> currentNodeNeighbors = currentNode.getNeighbors();
        if(currentNodeNeighbors.containsKey(name)){
            currentNode = currentNodeNeighbors.get(name);
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
}

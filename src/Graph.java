import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, Node> nodes;



    public Graph() {
        nodes = new HashMap<String, Node>();
    }

    public void addNode(String name, String description) {
        Node n = new Node(name, description);
        nodes.put(name, n);

    }

    public void addNode(String name) {
        Node n = new Node(name);
        nodes.put(name, n);
    }


    public void addDirectedEdge(String name1, String name2) {
        Node node1 = getNode(name1);
        Node node2 = getNode(name2);
        if (node1 != null && node2 != null) {
            node1.addNeighbor(node2);
        }

    }

    public Node getNode(String name) {
        return nodes.get(name);

    }

    public void addUndirectedEdge(String name1, String name2) {
        Node node1 = getNode(name1);
        Node node2 = getNode(name2);
        if (node1 != null && node2 != null) {
            node1.addNeighbor(node2);
            node2.addNeighbor(node1);
        }
    }


    public class Node {
        private String name;
        private HashMap<String, Node> neighbors;
        private String description;
        private ArrayList<Item> items;

        public Node(String name) {
            this.name = name;
            neighbors = new HashMap<>();
            description = "This room has no description";
            items = new ArrayList<>();
        }

        public Node(String name, String description) {
            this.name = name;
            neighbors = new HashMap<>();
            this.description = description;
            items = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public void addNeighbor(Node n) {

            String nodeName = n.getName();
            neighbors.put(nodeName, n);

        }

        public String getNeighborNames() {
            String names = "";
            for (String n : neighbors.keySet()) {
                names += neighbors.get(n).getName() + " ";
            }
            return names;

        }

        public Node getNeighbor(String name) {
            return neighbors.get(name);

        }

        public HashMap<String, Node> getNeighbors() {
            return neighbors;
        }

        public ArrayList <Item> getItems() {
            return items;
        }

        public String displayItems() {

            String itemNames = "These items are in the room: ";
            for (Item item : items) {
                String itemName = item.getName();
                itemNames += itemName + ",";
            }
            return itemNames;
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

        public void addItem(String name) {
            Item item = new Item(name);
            items.add(item);
        }

        public void addItem(String name, String description) {
            Item item = new Item(name, description);
            items.add( item);
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

        public void destroyItem(String name) {
            items.remove(name);
        }
    }
}

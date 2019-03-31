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

    public void addNode(String name){
        Node n = new Node(name);
        nodes.put(name,n);
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

        public Node(String name) {
            this.name = name;
            neighbors = new HashMap<>();
            description = "This room has no description";
        }

        public Node(String name, String description) {
            this.name = name;
            neighbors = new HashMap<>();
            this.description = description;
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
                names += neighbors.get(n) + " ";
            }
            return names;

        }

        public Node getNeighbor(String name) {
            return neighbors.get(name);

        }

        public HashMap<String, Node> getNeighbors() {
            return neighbors;
        }
    }
}

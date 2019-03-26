import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(String name) {
        Node n = new Node(name);
        nodes.add(n);
    }

    public void addDirectedEdge(String name1, String name2) {
        Node node1 = getNode(name1);
        Node node2 = getNode(name2);
        if (node1 != null && node2 != null) {
            node1.addNeighbor(node2);
        }

    }

    public Node getNode(String name) {
        for (int i = 0; i < nodes.size(); i++) {
            Node currrentNode = nodes.get(i);
            if (currrentNode.getName().equals(name)) return currrentNode;
        }

        return null;
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
        private ArrayList<Node> neighbors;

        public Node(String name) {
            this.name = name;
            neighbors = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Node n) {
            neighbors.add(n);
        }

        public String getNeighborNames() {
            String names = "";
            for (int i = 0; i < neighbors.size(); i++) {
                names += neighbors.get(i).getName() + ",";
            }
            return names;
        }

        public Node getNeighbor(String name) {
            for (int i = 0; i < neighbors.size(); i++) {
                Node n = neighbors.get(i);
                if (n.getName().equals(name)) {
                    return n;
                }
            }
            return null;
        }
    }


}

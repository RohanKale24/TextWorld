import jdk.nashorn.internal.runtime.regexp.joni.CodeRangeBuffer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Graph g = createGraph();
         ArrayList<Creature> allCreatures = new ArrayList<>();
        ArrayList<Item> allItems = new ArrayList<>();
        Graph.Node currentRoom = g.getNode("hall");
        Player p = createPlayer(currentRoom);
        createCreatures(g, allCreatures,p);
        createItems(g,allItems);


        String response = "";
        Scanner in = new Scanner(System.in);



        System.out.println("Your commands are: go, look, add room,take, drop, help, or quit");

        do {
            System.out.println("You are currently in the " + currentRoom.getName());
            System.out.println("What do you want to do?");

            response = in.nextLine();
            String[] words = response.split(" ");
            if (words[0].equals("go") || words[0].equals("Go")) {
                String nodeName = getValidNodeName(words, g);
                if (nodeName != null && !nodeName.equals(currentRoom.getName()) && currentRoom.getNeighborNames().contains(nodeName)) {
                    currentRoom = g.getNode(nodeName);
                    p.moveToRoom(nodeName);
                    moveAllCreatures(allCreatures);
                    updatePlayerLocation(allCreatures,p);
                } else {
                    System.out.println("Please type a valid room name");
                    System.out.println("The neighboring rooms are: " + currentRoom.getNeighborNames());
                }

            } else if (words[0].equals("look") || words.equals("Look")) {
                System.out.println("The neighboring rooms are: " + currentRoom.getNeighborNames());
                System.out.println("The items in this room are: " + currentRoom.displayItems());
                System.out.println("The animals in this room are: " + currentRoom.displayAnimals());

            } else if (words[0].equals("add") || words.equals("add")) {
                System.out.println("Type the name of the room");
                String name = in.nextLine();
                System.out.println("Type a description if you want, if you don't just hit enter");
                String description = in.nextLine();
                if (description.length() > 0) {
                    g.addNode(name, description);
                } else {
                    g.addNode(name);
                }
            } else if (words[0].equals("quit") || words.equals("Quit")) {
                break;
            } else if (words[0].equals("help") || words.equals("Help")) {
                System.out.println("Your commands are: go, look, add room,take, drop, help, or quit");
                System.out.println("to use the go command simply type go and a valid room name and it will take you to that rooom");
                System.out.println("to use the look command simply type look and the rooms you can move to from your current room will be displayed");
                System.out.println("to use add room simply type add and prompts will follow for you to give your new room a name and description");
                System.out.println("to take an item simply type take and a valid item name that is in that room and it will be added to your inventory");
                System.out.println("to take an item simply type drop and a valid item name that is in your inventory and it will be added to the room");

                System.out.println("to quit simply type quit");
            } else if (words[0].equals("take") || words.equals("Take")) {
                String itemName = getValidItemName(words, currentRoom);
                if (itemName != null) {
                    p.addItem(currentRoom.removeItem(itemName));
                } else {
                    System.out.println("There is no valid item name");
                    System.out.println("The items in this room are: " + currentRoom.displayItems());
                }


            } else if (words[0].equals("drop") || words.equals("Drop")) {
                String itemName = getValidItemName(words, p);
                if (itemName != null) {
                    currentRoom.addItem(p.removeItem(itemName));
                } else {
                    System.out.println("There is no valid item name");
                    System.out.println("The items in your inventory are: " + p.displayItems());
                }


            } else {
                System.out.println("Invalid command! Please try again with any of these commands: go, look, add room,take, drop, help, or quit"/* display all commands*/);
            }


        } while (true);

    }

    private static void updatePlayerLocation(ArrayList<Creature> allCreatures, Player player) {
        for (int i = 0; i < allCreatures.size(); i++) {
            Creature c = allCreatures.get(i);
            if(c instanceof Wumpus){
                ((Wumpus) c).setPlayerRoom(player);
            }
            else if(c instanceof Popstar){
                ((Popstar) c).setPlayerRoom(player);
            }
        }

    }

    private static void createItems(Graph g, ArrayList<Item> allItems) {
        Graph.Node randRoom = getRandomNode(g);
        Item yeet = new Item("yeet", "the most powerful yeet to yeet the yeet");
        allItems.add(yeet);
        randRoom.addItem(yeet);

        randRoom = getRandomNode(g);
        Item waterBottle = new Item("water bottle", "It is a normal water bottle with refreshing water");
        allItems.add(waterBottle);
        randRoom.addItem(waterBottle);
    }

    private static Player createPlayer(Graph.Node currentRoom) {
        Scanner in = new Scanner(System.in);
        Player p =new Player(currentRoom);
        System.out.println("Type your name");
        String playerName = in.nextLine();
        p.setName(playerName);
        System.out.println("Type a description if you want, if you don't just hit enter");
        String playerDesciption = in.nextLine();
        if (playerDesciption.length() > 0) {
            p.setDescription(playerDesciption);
        }
        return p;

    }

    private static void createCreatures(Graph g, ArrayList<Creature> allCreatures,Player player) {
        Graph.Node randRoom = getRandomNode(g);
        Chicken c = new Chicken("Lord Farquad", randRoom);
        randRoom.addCreature(c);
        allCreatures.add(c);

        randRoom = getRandomNode(g);
        Chicken d = new Chicken("Chicken Little", randRoom);
        randRoom.addCreature(d);
        allCreatures.add(d);

        randRoom = getRandomNode(g);
        Popstar popstar = new Popstar("Fire Drake Noetic", randRoom);
        randRoom.addCreature(popstar);
        allCreatures.add(d);

        randRoom = getRandomNode(g);
        Wumpus w = new Wumpus("Nabbit",randRoom);
        randRoom.addCreature(w);
        allCreatures.add(w);

        updatePlayerLocation(allCreatures,player);
    }

    private static Graph.Node getRandomNode(Graph g) {
        ArrayList<Graph.Node> Nodes = new ArrayList<>(g.getNodes().values());

        int randomIndex = (int) (Math.random() * Nodes.size());
        Graph.Node newRoom = Nodes.get(randomIndex);

        return newRoom;
    }

    private static Graph createGraph() {
        Graph graph = new Graph();
        graph.addNode("hall", "This is a hall. It moves you from one room to the next.");
        graph.addNode("closet", "This is a closet. This is where you store things.");
        graph.addNode("dungeon", "This is a dungeon. You do not want to be in a dungeon.");
        graph.addNode("fake","This is not a real room. You have been tricked");
        graph.addNode("imaginary","You are imagining rooms now");

        graph.addDirectedEdge("hall", "dungeon");
        graph.addUndirectedEdge("hall", "closet");
        graph.addUndirectedEdge("closet","fake");
        graph.addUndirectedEdge("fake","imaginary");

        return graph;
    }

    private static void moveAllCreatures(ArrayList<Creature> allCreatures) {
        for (Creature c : allCreatures) {
            c.move();
        }
    }

    private static String getValidNodeName(String[] words, Graph g) {//need to add code for room names for multiple word names
        for (int i = 0; i < words.length; i++) {
            if (g.getNode(words[i]) != null) {
                return words[i];
            }

        }
        return null;
    }

    public static String getValidItemName(String[] words, Graph.Node currentNode) {

        for (int i = 0; i < words.length; i++) {
            if (currentNode.hasItem(words[i])) {
                return words[i];
            }

        }
        return null;
    }

    public static String getValidItemName(String[] words, Player p) {
        for (int i = 0; i < words.length; i++) {
            if (p.hasItem(words[i])) {
                return words[i];
            }

        }
        return null;
    }
}




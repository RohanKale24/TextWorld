import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();
        g.addNode("hall");
        g.addNode("closet");
        g.addNode("dungeon");

        g.addDirectedEdge("hall","dungeon");
        g.addUndirectedEdge("hall","closet");



        Graph.Node currentRoom = g.getNode("hall");
        String response = "";
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("Your commands are: go,look, or add room");
            System.out.println("You are currently in the " + currentRoom.getName());
            System.out.println("What do you want to do?");

            response = in.nextLine();
            String [] words = response.split(" ");
            if(words[0].equals("go") || words[0].equals("Go")){
                String nodeName = getValidNodeName(words,g);
                if(nodeName!=null){
                    currentRoom = g.getNode(nodeName);
                }

            }
            else if(words[0].equals("look")||words.equals("Look")){
                System.out.println("The neighboring rooms are: " + currentRoom.getNeighborNames());
            }
            else if(words[0].equals("add")||words.equals("add")){

            }
            else if(words[0].equals("quit")||words.equals("Quit")){
                break;
            }
            else{
                System.out.println("Invalid command! Please try again with any of these commands: go,look,or add room"/* display all commands*/);
            }


        }while(!response.equals("quit")||!response.equals("Quit"));

    }

    private static String getValidNodeName(String[] words,Graph g){
        for (int i = 0; i < words.length; i++) {
            if(g.getNode(words[i])!=null){
                return words[i];
            }

        }
        return null;
    }
}

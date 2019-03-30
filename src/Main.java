import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();
        g.addNode("hall","This is a hall. It moves you from one room to the next.");
        g.addNode("closet", "This is a closet. This is where you store things.");
        g.addNode("dungeon","This is a dungeon. You do not want to be in a dungeon.");

        g.addDirectedEdge("hall","dungeon");
        g.addUndirectedEdge("hall","closet");



        Graph.Node currentRoom = g.getNode("hall");
        String response = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Your commands are: go, look, add room, help, or quit");

        do{
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
                System.out.println("Type the name of the room");
                String name = in.nextLine();
                System.out.println("Type a description of you want, if you dont just hit enter");
                String description = in.nextLine();
                if(description.length()>0){
                    g.addNode(name,description);
                }
                else {
                    g.addNode(name);
                }
            }
            else if(words[0].equals("quit")||words.equals("Quit")){
                break;
            }
            else if(words[0].equals("help")||words.equals("Help")){
                System.out.println("Your commands are: go, look, add room, help, or quit");
                System.out.println("to use the go command simply type go and a valid room name and it will take you to that rooom");
                System.out.println("to use the look command simply type look and the rooms you can move to from your current room will be displayed");
                System.out.println("to use add room simply type add and prompts will follow for you to give your new room a name and description");
                System.out.println("to quit simply type quit");
            }
            else{
                System.out.println("Invalid command! Please try again with any of these commands: go,look,or add room"/* display all commands*/);
            }


        }while(true);

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

public class goCommand implements Command {
    @Override
    Player p;
    Graph g;
    Graph.Node currentRoom;
    String userInput;
    public goCommand(String userInput,Player p ,Graph g){
        this.p=p;
        this.g=g;
        this.userInput = userInput;
    }
    public void init() {
        currentRoom = p.getCurrentNode();
    }

    @Override
    public boolean execute() {
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
    }
}

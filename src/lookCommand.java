public class lookCommand implements Command {

    Player p;
    Graph.Node currentRoom;
    public lookCommand(Player p){
        this.p=p;
    }
    public void init() {
        currentRoom = p.getCurrentNode();
    }

    @Override
    public boolean execute() {
        init();
        System.out.println("The neighboring rooms are: " + currentRoom.getNeighborNames());
        System.out.println("The items in this room are: " + currentRoom.displayItems());
        System.out.println("The animals in this room are: " + currentRoom.displayAnimals());
        return true;
    }
}

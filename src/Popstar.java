public class Popstar extends Creature{
    Graph.Node playerRoom = null;

    public Popstar(String name, Graph.Node currentRoom){
        super();
        this.currentRoom = currentRoom;
        this.name = name;
    }
    @Override
    public void move() {

    }
    public void getPlayerRoom(Player p){
        this.playerRoom = p.getCurrentNode();
    }
    public void getPlayerName(Graph.Node playerRoom){
        this.playerRoom = playerRoom;
    }
}

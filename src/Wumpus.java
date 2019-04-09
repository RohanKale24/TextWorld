public class Wumpus extends Creature{
    Graph.Node playerRoom = null;
    public Wumpus(String name, Graph.Node currentRoom){
        super();
        this.currentRoom = currentRoom;
        this.name = name;
    }

    public void move() {

    }
    public void getPlayerRoom(Player p){
        this.playerRoom = p.getCurrentNode();
    }
    public void getPlayerName(Graph.Node playerRoom){
        this.playerRoom = playerRoom;
    }
}

import java.util.ArrayList;

public class Wumpus extends Creature{
    Graph.Node playerRoom = null;
    public Wumpus(String name, Graph.Node currentRoom){
        super();
        this.currentRoom = currentRoom;
        this.name = name;
    }

    public void move() {
        if(isWithin2StepsOfPlayer()){

        }
        else{
            super.moveToRandomRoom();
        }
    }

    private boolean isWithin2StepsOfPlayer() {
        ArrayList<String> neighborsForCurrentRoom = new ArrayList<>(currentRoom.getNeighbors().keySet());
        ArrayList<String> neighborsForPlayerRoom = new ArrayList<>(playerRoom.getNeighbors().keySet());
        if(neighborsForCurrentRoom.size()>neighborsForPlayerRoom.size()) {
            for (int i = 0; i < neighborsForCurrentRoom.size(); i++) {
                String nodeName = neighborsForCurrentRoom.get(i);
                if (neighborsForPlayerRoom.contains(nodeName)){
                    return true;
                }
            }
        }
        else{
            for (int i = 0; i < neighborsForPlayerRoom.size(); i++) {
                 String nodeName = neighborsForPlayerRoom.get(i);
                if (neighborsForCurrentRoom.contains(nodeName)){
                    return true;
                }

            }
        }
        return false;
    }

    public void getPlayerRoom(Player p){
        this.playerRoom = p.getCurrentNode();
    }
    public void getPlayerName(Graph.Node playerRoom){
        this.playerRoom = playerRoom;
    }
}

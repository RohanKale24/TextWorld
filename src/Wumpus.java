

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
            //move away
            ArrayList<String> nonOverlappedRooms = findNonOverlappedRooms();
            String nodeName = getRandomName(nonOverlappedRooms);
            Graph.Node newRoom = currentRoom.getNeighbor(nodeName);
            super.moveCreatureBetweenRooms(newRoom);
        }
        else{
            super.moveToRandomRoom();
        }
    }

    private String getRandomName(ArrayList<String> nonOverlappedRooms) {
        int randomIndex = (int)(Math.random()*nonOverlappedRooms.size());
        String newNodeName = nonOverlappedRooms.get(randomIndex);
        return newNodeName;
    }

    private ArrayList<String> findNonOverlappedRooms() {
        ArrayList<String> neighborsForCurrentRoom = new ArrayList<>(currentRoom.getNeighbors().keySet());
        ArrayList<String> neighborsForPlayerRoom = new ArrayList<>(playerRoom.getNeighbors().keySet());
        ArrayList<String> overlappingRooms = new ArrayList<>();
        if(neighborsForCurrentRoom.size()>neighborsForPlayerRoom.size()) {
            for (int i = 0; i < neighborsForCurrentRoom.size(); i++) {
                String nodeName = neighborsForCurrentRoom.get(i);
                if (neighborsForPlayerRoom.contains(nodeName)||neighborsForPlayerRoom.contains(currentRoom.getName())){
                    overlappingRooms.add(nodeName);
                }
            }
        }
        else{
            for (int i = 0; i < neighborsForPlayerRoom.size(); i++) {
                String nodeName = neighborsForPlayerRoom.get(i);
                if (neighborsForCurrentRoom.contains(nodeName)||neighborsForCurrentRoom.contains(playerRoom.getName())){
                    overlappingRooms.add(nodeName);
                }

            }
        }
        return overlappingRooms;
    }

    private boolean isWithin2StepsOfPlayer() {
        ArrayList<String> neighborsForCurrentRoom = new ArrayList<>(currentRoom.getNeighbors().keySet());
        ArrayList<String> neighborsForPlayerRoom = new ArrayList<>(playerRoom.getNeighbors().keySet());
        if(neighborsForCurrentRoom.size()>neighborsForPlayerRoom.size()) {
            for (int i = 0; i < neighborsForCurrentRoom.size(); i++) {
                String nodeName = neighborsForCurrentRoom.get(i);
                if (neighborsForPlayerRoom.contains(nodeName)||neighborsForPlayerRoom.contains(currentRoom.getName())){
                    return true;
                }
            }
        }
        else{
            for (int i = 0; i < neighborsForPlayerRoom.size(); i++) {
                 String nodeName = neighborsForPlayerRoom.get(i);
                if (neighborsForCurrentRoom.contains(nodeName)||neighborsForCurrentRoom.contains(playerRoom.getName())){
                    return true;
                }

            }
        }
        return false;
    }

    public void setPlayerRoom(Player p){
        this.playerRoom = p.getCurrentNode();
    }
    public void setPlayerRoom(Graph.Node playerRoom){
        this.playerRoom = playerRoom;
    }
}

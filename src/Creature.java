import java.util.ArrayList;
import java.util.HashMap;

public abstract class Creature {
    protected Graph.Node currentRoom;
    protected String name;
    protected String description;

    public abstract void move();

    public void moveToRandomRoom(){
        ArrayList<Graph.Node> rooms = new ArrayList<>(currentRoom.getNeighbors().values());
        if(rooms.size()>0) {
            int randomIndex = (int) (Math.random() * rooms.size());
            Graph.Node newRoom = rooms.get(randomIndex);
            currentRoom.removeCreature(this);
            currentRoom = newRoom;
            currentRoom.addCreature(this);
        }


    }

    public String getName() {
        return name;
    }

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }


}

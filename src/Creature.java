

public abstract class Creature {
    protected Graph.Node currentRoom;
    protected String name;
    protected String description;

    public abstract void move();

    public void moveToRandomRoom(){
        String names = currentRoom.getNeighborNames();
        String[] namesArray = names.split(" ");
        int randomIndex = (int)(Math.random()*namesArray.length);
        String newRoomName = namesArray[randomIndex];
        currentRoom = currentRoom.getNeighbors().get(newRoomName);
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

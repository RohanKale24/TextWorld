public class Chicken extends Creature{


    public Chicken(String name,Graph.Node currentRoom){
        super();
        this.name = name;
        this.currentRoom = currentRoom;
        description = "This chicken has no description";
    }
    public Chicken(String name,String description, Graph.Node currentRoom){
        super();
        this.name = name;
        this.description = description;
        this.currentRoom = currentRoom;
    }

    @Override
    public void move() {
        super.moveToRandomRoom();
    }
}

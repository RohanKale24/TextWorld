import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    String name;
    String description;
    ArrayList<Item> items;

    public Player(){
        name = "No Name";
        description = "This player had no description";
        items = new ArrayList<>();

    }
    public Player(String name){
        this.name = name;
        description = "This player had no description";
        items = new ArrayList<>();
    }
    public Player(String name, String description){
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }
    public void addItem(Item item){
        items.add(item);
    }
    public Item removeItem(String name){

    }
}

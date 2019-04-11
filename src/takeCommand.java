public class takeCommand implements Command {
    Graph.Node level;
    String itemName;
    public takeCommand(Graph.Node level){
        this.level = level;

    }

    @Override
    public void init(String userInput) {
        this.itemName = getItemName(userInput);
    }


    @Override
    public boolean execute() {
        return false;
    }
}

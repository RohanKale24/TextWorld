public class takeCommand implements Command {
    Player p;
    String itemName;
    String userInput;

    public takeCommand(String userInput, Player p) {
        this.userInput = userInput;
        this.p = p;
    }



    @Override
    public void init() {
        String itemName = findItemName();
    }

    private String findItemName() {
        String [] words = userInput.split(" ");
        Graph.Node currentRoom = p.getCurrentNode();
        for (int i = 0; i < words.length; i++) {
            if (currentRoom.hasItem(words[i])) {
                return words[i];
            }

        }
        System.out.println("There is no valid item name");
        System.out.println("The items in this room are: " + currentRoom.displayItems());
        return null;
    }

    @Override
    public boolean execute() {
        init();
        Graph.Node currentRoom = p.getCurrentNode();
        Item i = currentRoom.removeItem(itemName);
        if (i == null) {
            System.err.println("The room doesn't have that item!");
            return false;
        }
        p.addItem(i);
        return true;
    }

}





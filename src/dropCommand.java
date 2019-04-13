public class dropCommand implements Command {
    String userInput;
    Player p;
    Graph.Node currentRoom;
    String itemName;
    public dropCommand(String userInput, Player p) {
        this.userInput = userInput;
        this.p = p;
    }

    @Override
    public void init() {
        currentRoom = p.getCurrentNode();
        String itemName = findItemName(userInput);
    }

    private String findItemName(String userInput) {
        String [] words = userInput.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (p.hasItem(words[i])) {
                return words[i];
            }

        }
        return null;

    }


    @Override
    public boolean execute() {
        init();
        if (itemName != null) {
            currentRoom.addItem(p.removeItem(itemName));
            return true;
        } else {
            System.out.println("There is no valid item name");
            System.out.println("The items in your inventory are: " + p.displayItems());
            return false;
        }

    }
}

public class helpCommand implements Command {
    @Override
    public void init() {

    }

    @Override
    public boolean execute() {
        init();
        System.out.println("Your commands are: go, look, add room,take, drop, help, or quit");
        System.out.println("to use the go command simply type go and a valid room name and it will take you to that rooom");
        System.out.println("to use the look command simply type look and the rooms you can move to from your current room will be displayed");
        System.out.println("to use add room simply type add and prompts will follow for you to give your new room a name and description");
        System.out.println("to take an item simply type take and a valid item name that is in that room and it will be added to your inventory");
        System.out.println("to take an item simply type drop and a valid item name that is in your inventory and it will be added to the room");
        System.out.println("to quit simply type quit");
        return true;
    }
}

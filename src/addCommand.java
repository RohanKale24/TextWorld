import java.util.Scanner;

public class addCommand implements Command {
    String name;
    String description;
    Graph g;
    public addCommand(Graph g) {
        this.g=g;
    }

    @Override
    public void init() {
        Scanner in = new Scanner(System.in);
        System.out.println("Type the name of the room");
         name = in.nextLine();
        System.out.println("Type a description if you want, if you don't just hit enter");
         description = in.nextLine();
    }

    @Override
    public boolean execute() {
        init();
        if (description.length() > 0) {
            g.addNode(name, description);
        } else {
            g.addNode(name);
        }
        return true;
    }
}

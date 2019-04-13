import java.util.HashMap;

public class masterCommand {

    private final String userInput;
    private final Player p;
    Graph g;

    HashMap<String,Command> commands;
    public masterCommand(String userInput,Player p,Graph g){
        this.userInput = userInput;
        this.p = p;
        this.g = g;
        commands = new HashMap<>();
        initCommands();
    }

    public String parseCommand(String input){
        String [] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(commands.keySet().contains(word)){
                return word;
            }
        }
        return "";
    }

    private void initCommands() {
        commands.put("go", new goCommand());
        commands.put("look",new lookCommand(p));
        commands.put("add",new addCommand(g));
        commands.put("quit",new quitCommand());
        commands.put("help", new helpCommand());
        commands.put("take",new takeCommand(userInput,p));
        commands.put("drop", new dropCommand(userInput,p));

    }
}

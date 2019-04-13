import java.util.HashMap;

public class masterCommand {

    private final String userInput;
    private final Player p;

    HashMap<String,Command> commands;
    public masterCommand(String userInput,Player p){
        this.userInput = userInput;
        this.p = p;
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
        commands.put("look",new addCommand());
        commands.put("add",new addCommand());
        commands.put("quit",new quitCommand());
        commands.put("help", new helpCommand());
        commands.put("take",new takeCommand(userInput,p));
        commands.put("drop", new dropCommand(userInput,p));

    }
}

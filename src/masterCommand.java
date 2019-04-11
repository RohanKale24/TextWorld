import java.util.HashMap;

public class masterCommand {

    HashMap<String,Command> commands;
    public masterCommand(){
        commands = new HashMap<>();
        initCommands();
    }

    public String parseCommand(String input){
        String [] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Command c = commands.get(word);
        }
    }

    private void initCommands() {
        commands.put("go", new goCommand());
        commands.put("look",new addCommand());
        commands.put("add",new addCommand());
        commands.put("quit",new quitCommand());
        commands.put("help", new helpCommand());
        commands.put("take",new takeCommand(/*Graph.Node*/));
        commands.put("drop", new dropCommand());

    }
}

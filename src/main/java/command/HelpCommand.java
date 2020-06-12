package command;

import java.util.Map;

public class HelpCommand implements Command {
    private CommandFactory commandFact;
    private Map<String, Command> commandMap = commandFact.getMap();

    @Override
    public void execute(String s) {
        if(s.isEmpty()){
            System.out.println("This is the list of all commands..");
            for(String key : commandMap.keySet()){
                System.out.println(key);
            }
        }
    }
}

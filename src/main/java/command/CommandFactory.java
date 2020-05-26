package command;

import com.sun.tools.javah.Util;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<String,Command> commandMap = new HashMap<String, Command>();

    static{
        commandMap.put("quit", new RegameCommand());
        commandMap.put("info", new InfoCommand());
        commandMap.put("take", new TakeCommand());
        commandMap.put("drop", new DropCommand());
        commandMap.put("attack with", new AttackCommand());
        commandMap.put("go", new GoCommand());
        commandMap.put("map", new MapCommand());
        commandMap.put("autopilot", new AutoCommand());
        commandMap.put("help",new HelpCommand());
        commandMap.put("play",new PlayCommand());
        commandMap.put("load",new LoadCommand());
        commandMap.put("save",new SaveCommand());
        commandMap.put("exit", new ExitCommand());
    }

    public static Command getCommand(String cmd){
        return (commandMap.get(cmd));
    }
}

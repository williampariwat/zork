package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;
import java.util.Map;

public class HelpCommand implements Command {
    private CommandFactory commandFact;
    private Map<String, Command> commandMap = commandFact.getMap();


    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {
        if(s == null){
            System.out.println("This is the list of all commands..");
            for(String key : commandMap.keySet()){
                System.out.println(key);
            }
        }
    }
}

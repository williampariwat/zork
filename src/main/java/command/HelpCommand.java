package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import Map.mapReader;

public class HelpCommand implements Command {
    private CommandFactory commandFact;
    private Map<String, Command> commandMap = commandFact.getMap();
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;

    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory,  boolean startStatus, mapReader mapTracker) {
        if(s == null){
            System.out.println("This is the list of all commands..");
            for(String key : commandMap.keySet()){
                System.out.println(key);
            }
        }
        this.currentRoom = currentRoom;
        this.playerStatus = player;
        this.currentInventory = inventory;
        this.startStatus = startStatus;
        this.mapTracker = mapTracker;
    }

    @Override
    public Room getUpdatedRoom() {
        return this.currentRoom;
    }

    @Override
    public Player getUpdatedPlayer() {
        return this.playerStatus;
    }

    @Override
    public Inventory getUpdatedInventory() {
        return this.currentInventory;
    }


    @Override
    public boolean inGameCommand() {
        return true;
    }

    @Override
    public boolean getStartStatus() {
        return this.startStatus;
    }

    @Override
    public mapReader getMapTracker() {
        return this.mapTracker;
    }

}

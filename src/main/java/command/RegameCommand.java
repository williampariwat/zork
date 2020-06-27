package command;

import Items.Inventory;
import Items.Items;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RegameCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    mapReader mapTracker;
    boolean startStatus;

    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader mapTracker) throws FileNotFoundException {
        if(s == null){
            System.out.println("Game Over");
            this.startStatus = false;
            this.playerStatus = new Player();
            this.currentInventory = new Inventory(new ArrayList<Items>());

            System.out.println("System is redirecting to the game menu....");
            Command command = CommandFactory.getCommand("play");
            command.execute(null,currentRoom,this.playerStatus,this.currentInventory,this.startStatus,mapTracker);
        }else{
            System.out.println("This command does not require user to enter second argument.");
            this.mapTracker = mapTracker;
            this.currentRoom = currentRoom;
            this.playerStatus = player;
            this.currentInventory = inventory;
            this.startStatus = startStatus;
        }
    }

    @Override
    public Room getUpdatedRoom() {
        return currentRoom;
    }

    @Override
    public Player getUpdatedPlayer() {
        return playerStatus;
    }

    @Override
    public Inventory getUpdatedInventory() {
        return currentInventory;
    }

    @Override
    public boolean inGameCommand() {
        return true;
    }

    @Override
    public boolean getStartStatus() {
        return false;
    }

    @Override
    public mapReader getMapTracker() {
        return this.mapTracker;
    }

}

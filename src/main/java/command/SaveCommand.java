package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;


    private String saveDirectory = "/Users/wiliamh/Desktop/Work/Sophomore Year/Term III/Software Construction/Zork/Save";
    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader mapTracker) throws FileNotFoundException {
        Starter save = new Starter();
        save.setStarter(currentRoom,player,inventory,startStatus,mapTracker);
        if(s != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream(saveDirectory + s + ".ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(save);
                out.close();
                fileOut.close();
                System.out.println("Saved as " + saveDirectory + ".");
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
        this.currentRoom = currentRoom;
        this.playerStatus = player;
        this.currentInventory = inventory;
        this.mapTracker = mapTracker;
        this.startStatus = startStatus;
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
        return false;
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

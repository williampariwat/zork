package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    Boolean startStatus;
    mapReader mapTracker;
    private String saveDirectory = "/Users/wiliamh/Desktop/Work/Sophomore Year/Term III/Software Construction/Zork/Save";
    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader mapTracker ) {
        try {
            FileInputStream fileIn = new FileInputStream(saveDirectory + s + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Starter game = (Starter) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Checkpoint save loaded.");
            this.currentRoom = game.getCurrentRoom();
            this.playerStatus = game.getPlayer();
            this.currentInventory = game.getPlayerInventory();
            this.startStatus = game.getGameStatus();
            this.mapTracker = game.getMap();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Checkpoint load failed. Save game might not exist or corrupted");
        }
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

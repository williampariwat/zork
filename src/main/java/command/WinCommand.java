package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public class WinCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;
    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory,  boolean startStatus, mapReader mapTracker) {

        if(s == null){
            if(inventory.totalToken() == 5 && currentRoom.getRoomName().equals("Shark Room")){
                System.out.println("Congratulations! You've successfully win the game!");
                for(int i = 3 ; i != 0; i--){
                    System.out.println("Game turning off in" + i);
                }
                System.exit(0);

            }
        }else if(!currentRoom.getRoomName().equals("Shark Room")){
            System.out.println("Please go to the Shark Room in order to use this command.");
        }else if(inventory.totalToken() < 5){
            System.out.println("Not enough token to finish the game.");
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

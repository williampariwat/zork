package command;

import Items.Items;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;
import Items.Inventory;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DropCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;

    public void execute(String s, Room room, Player player, Inventory inventory, boolean startStatus, mapReader mapTracker) throws FileNotFoundException {


        if (s == null) {
            System.out.println("Drop what?");
        } else {
//            for (int i = 0; i < playerInventory.size(); i++) {
//                if (playerInventory.get(i).getItemName().equals(s)) {
//                    Items drop = playerInventory.get(i);
//                    playerInventory.remove(i);
//                    roomInventory.add(playerInventory.get(i));
//                    System.out.println(drop.getItemName()+ " has dropped on the floor of this room.");
//                }
//            }
            if(inventory.isInside(s) && !s.equals("fist")){
                room.getArrayInventory().add(inventory.getItem(s));
                inventory.removeItem(s);
            }else if(s.equals("fist")){
                System.out.println("Well done, you're basically just drop your hands on the floor");
                System.out.println("You died from losing too much blood");
                System.out.println("Game over");
                Command command = CommandFactory.getCommand("quit");
                command.execute(null,this.currentRoom,this.playerStatus,this.currentInventory,startStatus,mapTracker);
                //Find some way to replay the game;
            }
            else {
                System.out.println("Invalid item name!");
            }
        }

        this.currentRoom = room;
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

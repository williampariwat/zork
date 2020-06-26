package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoCommand implements Command {

    //    public Starter starter = new Starter();
//    public Room currentRoom = starter.getCurrentRoom();
    String[] directions = {"north", "south", "east", "west"};
    List<String> dir = Arrays.asList(directions);
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;


    @Override
    public void execute(String direction, Room room, Player player, Inventory inventory, boolean startStatus, mapReader mapTracker) {
        if (direction == null) {
            System.out.println("Go where?");
            return;
        } else {

            if (!dir.contains(direction)) {
                System.out.println("Go where?");
                return;
            } else {

                Room nextRoom = room.nextRoom(direction);

                if (nextRoom == null) {
                    System.out.println("This is the end of the map");
                } else {
                    room = nextRoom;
                    System.out.println(room.longDescription());
                    room.getMonstersDialogue();
                    System.out.println("Items on the floor: ");
                    System.out.println();
                    room.getRoomInventory();
                    if(player.getHealthBar() < 100) {
                        player.increaseHP(5);
                    }

                }
            }
        }
        this.currentRoom = room;
        this.playerStatus = player;
        this.currentInventory = inventory;
        this.startStatus = startStatus;
        this.mapTracker = mapTracker;



        //Fix the room
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
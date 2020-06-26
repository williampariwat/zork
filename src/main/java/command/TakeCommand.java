package command;

import Items.Items;
import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;

import java.util.ArrayList;

public class TakeCommand implements Command {

    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;

    @Override
    public void execute(String s, Room room, Player player, Inventory inventory,boolean startStatus, mapReader mapTracker) {
        ArrayList<Items> roomInventory = room.getArrayInventory();
        if(s == null){
            System.out.println("Take what?");
        }else{
//            for(int i = 0; i < roomInventory.size(); i++){
//                if(roomInventory.get(i).getItemName().equals(s)){
//                    inventory.addItem(roomInventory.get(i));
//                    roomInventory.remove(i);
//                }
//            }
            if(room.isInside(s) && !inventory.isFull() &&  room.getMonster().isDead()){
                inventory.addItem(room.getArrayInventory().get(0));
                room.getArrayInventory().remove(0);
            }else if(room.isInside(s) && !inventory.isFull() && room.getMonster().noMonster()){
                inventory.addItem(room.getArrayInventory().get(0));
                room.getArrayInventory().remove(0);
            }
            else if(inventory.isFull()){
                System.out.println("Your inventory is full! Drop something!");
            }else if (!room.isInside(s)){
                System.out.println(s+" doesn't exist!");
            }else{
                System.out.println("You need to kill the Monster in order to take the item!");
            }
        }
        this.currentRoom = room;
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
        return true;
    }

    @Override
    public boolean getStartStatus() {
        return this.startStatus ;
    }

    @Override
    public mapReader getMapTracker() {
        return this.mapTracker;
    }

}

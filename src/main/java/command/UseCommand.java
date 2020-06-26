package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;

public class UseCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;
    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory,boolean startStatus, mapReader mapTracker) {
        if( s != null && inventory.isInside(s)){
            if(inventory.getItem(s).isMedicine() && player.getHealthBar() <= 100){
                player.increaseHP(inventory.getItem(s).getWeight());
                inventory.removeItem(s);
                System.out.println("Using " + s +" to heal your health..");
            }else{
                System.out.println("You can't use this item to heal you or you already have full health.");
            }
        }else if (!inventory.isInside(s)){
            System.out.println("Item does not exist in your inventory.");
        }else{
            System.out.println("Use what?");
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

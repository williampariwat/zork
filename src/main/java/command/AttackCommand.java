package command;

import Items.Inventory;
import Map.mapReader;
import Monsters.Monster;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AttackCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    Boolean startStatus;
    mapReader mapTracker;

    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader mapTracker) {
        ArrayList<Monster> monsters = currentRoom.getMonstersList();
        if (s == null) {
            System.out.println("Attack-with what?");
        } else {
            if (!monsters.get(0).isDead()) {

                for(int i = 0; i < inventory.getList().size(); i++){
                    if(inventory.getList().get(i).getItemName().equals(s)){
                        System.out.println("Attacking " + monsters.get(0).getMonsterName().toUpperCase() + " with " + inventory.getList().get(i).getItemName().toUpperCase() + ".");
                        monsters.get(0).attacked(((inventory.getList()).get(i).getWeight()));
                        player.attacked(monsters.get(0).getRandomizedAttackDamage());
                        if(monsters.get(0).isDead()){
                            System.out.println("The monster is dead.");
                        }
                        break;
                    }
                }
                if(!inventory.isInside(s)){
                    System.out.println("Weapon does not exist in the inventory!");
                }

            } else {
                System.out.println("The monster is dead.");

            }
            this.currentRoom = currentRoom;
            this.playerStatus = player;
            this.currentInventory = inventory;
            this.startStatus = startStatus;
            this.mapTracker = mapTracker;
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

package command;

import Items.Items;
import Map.mapReader;
import Monsters.Monster;
import Player.Player;
import Room.Room;
import Starter.Starter;
import Items.Inventory;

import java.util.ArrayList;

public class InfoCommand implements Command{

    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader mapTracker;

    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader mapTracker)
     {

        ArrayList<Items> listOfPlayerItems = inventory.getList();

        if(s == null){
            System.out.println("--------------------------------------------------");
            System.out.println("PLAYER'S STATS: ");
            System.out.println("--------------------------------------------------");
            System.out.println("Health bar: " +player.getHealthBar());
            System.out.println("Inventory Size: "+inventory.getSize());
            System.out.println("Inventory: ");

            inventory.printInventory();


            if(inventory.containsWeapon()){
                System.out.println("Your available weapon: ");
                for(int i = 0; i < listOfPlayerItems.size(); i++){
                    if(listOfPlayerItems.get(i).isWeapon()){
                        System.out.println("    Weapon: "+listOfPlayerItems.get(i).getItemName() + " | Power: "+listOfPlayerItems.get(i).getWeight());
                    }
                }
            }

            System.out.println("Your total power: "+ inventory.getAttackPower());

            System.out.println("Your Token: " + inventory.totalToken());

            System.out.println("--------------------------------------------------");
            System.out.println("MONSTER'S STAT: ");
            System.out.println("--------------------------------------------------");

            if(currentRoom.getMonstersList().get(0).getMonsterName().equals("None") || currentRoom.getMonstersList().get(0).isDead()){
                System.out.println("No monster in this room or it is dead");
            }
            else{
                Monster monster = currentRoom.getMonstersList().get(0);
                System.out.println("Monster Name: "+monster.getMonsterName());
                System.out.println("Monster HP: " + monster.getHealthBar());
                System.out.println("Monster Attack Damage: "+monster.getAttackDamage());
            }

            System.out.println("--------------------------------------------------");
            System.out.println("Room STAT: ");
            System.out.println("--------------------------------------------------");

            System.out.println(currentRoom.getDescription());
            currentRoom.getRoomInventory();
            System.out.println(currentRoom.exitString());
            System.out.println("--------------------------------------------------");





            this.currentRoom = currentRoom;
            this.playerStatus = player;
            this.currentInventory = inventory;
            this.mapTracker = mapTracker;
            this.startStatus = startStatus;

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

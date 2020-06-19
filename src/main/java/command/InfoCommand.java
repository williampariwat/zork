package command;

import Items.Items;
import Monsters.Monster;
import Player.Player;
import Room.Room;
import Starter.Starter;
import Items.Inventory;

import java.util.ArrayList;

public class InfoCommand implements Command{

    public void execute(String s, Room currentRoom, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {

        ArrayList<Items> listOfPlayerItems = inventory.getList();

        if(s == null){
            System.out.println("Player's Stats: ");
            System.out.println("--------------------------------------------------");
            System.out.println("Health bar: " +player.getHealthBar());

            System.out.print("Inventory: ");

            inventory.printInventory();

            if(inventory.containsWeapon()){
                System.out.println("Your available weapon: ");
                for(int i = 0; i < listOfPlayerItems.size(); i++){
                    if(listOfPlayerItems.get(i).isWeapon()){
                        System.out.println("Weapon: "+listOfPlayerItems.get(i).getItemName() + " Power: "+listOfPlayerItems.get(i).getWeight());
                    }
                }
            }

            System.out.println("Your total power: "+ inventory.getAttackPower());

            System.out.println("Your Token: " + inventory.totalToken());

            System.out.println("--------------------------------------------------");

            System.out.println("Room Stat: ");
            System.out.println(currentRoom.getDescription());
            currentRoom.getRoomInventory();
            System.out.println(currentRoom.exitString());
            System.out.println("--------------------------------------------------");

            System.out.println("Monster Stat: ");
            if(currentRoom.getMonstersList().isEmpty()){
                System.out.println("No monster in this room ");
            }else{
                Monster monster = currentRoom.getMonstersList().get(0);
                System.out.println("Monster Name: "+monster.getMonsterName());
                System.out.println("Monster HP: " + monster.getHealthBar());
                System.out.println("Monster Attack Damage: "+monster.getAttackDamage());
            }
            System.out.println("Saves: ");

            for(int i = 0; i < listOfSave.size();i++){
                System.out.println(listOfSave.get(i).getName());
            }




        }
    }
}

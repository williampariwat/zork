package command;

import Items.Items;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public class InfoCommand implements Command{
    public Starter starter = new Starter();
    public Room currentRoom = starter.getCurrentRoom();
    public ArrayList<Starter> listOfSave = starter.getListOfSave();
    public ArrayList<Items> listOfPlayerItems = starter.getPlayerInventory().getList();

    public void execute(String s) {
        System.out.println("HEY");
        if(s.isEmpty()){
            System.out.println(currentRoom.longDescription());

            System.out.println("Player's stats");
//            System.out.println("Hunger level: "+ );
            System.out.println("Health bar: " + starter.getPlayer().getHealthBar());
            System.out.println("Inventory: ");
            starter.getPlayerInventory().printInventory();

            if(starter.getPlayerInventory().containsWeapon()){
                System.out.println("Your available weapon: ");
                for(int i = 0; i < listOfPlayerItems.size(); i++){
                    if(listOfPlayerItems.get(i).isWeapon()){
                        System.out.println("Weapon: "+listOfPlayerItems.get(i).getItemName() + " Power: "+listOfPlayerItems.get(i).getWeight());
                    }
                }
            }

            System.out.println("Your total power: "+starter.getPlayerInventory().getAttackPower());

            System.out.println("Saves: ");
            for(int i = 0; i < listOfSave.size();i++){
                System.out.println(listOfSave.get(i).getName());
            }


        }
    }
}

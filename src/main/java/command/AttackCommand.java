package command;

import Items.Items;
import Items.Inventory;
import Monsters.Monster;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public class AttackCommand implements Command {


    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {
        ArrayList<Items> playerInventory = inventory.getList();
        ArrayList<Monster> monsters = currentRoom.getMonstersList();
        if (!monsters.get(0).isDead()) {
            //Show the inventory of the player have
            // Ask player if they want to see their total power
            // Function that show the power of that specific weapon
            for (int i = 0; i < playerInventory.size(); i++) {
                if (playerInventory.get(i).equals(s)) {
                    System.out.println("Attacking " + monsters.get(0).getMonsterName() + " with " + playerInventory.get(i).getItemName() + ".");

                    monsters.get(0).attacked((int) playerInventory.get(i).getWeight());


                }
            }
        }else{
            currentRoom.getMonstersList().remove(0);
            System.out.println("The monster is dead.");

        }
    }
}

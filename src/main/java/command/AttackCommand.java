package command;

import Items.Items;
import Monsters.Monster;
import Starter.Starter;

import java.util.ArrayList;

public class AttackCommand implements Command {

    private Starter starter;
    private ArrayList<Items> playerInventory = starter.getPlayerInventory().getList();
    private ArrayList<Monster> monsters = starter.getCurrentRoom().getMonstersList();

    @Override
    public void execute(String s) {
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
            starter.getCurrentRoom().getMonstersList().remove(0);
            System.out.println("The monster is dead.");

        }
    }
}

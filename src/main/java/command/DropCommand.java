package command;

import Items.Items;
import Starter.Starter;
import Items.Inventory;

import java.util.ArrayList;

public class DropCommand implements Command {
    private Starter starter;
    private ArrayList<Items> roomInventory = starter.getCurrentRoom().getArrayInventory();
    private ArrayList<Items> playerInventory = starter.getPlayerInventory().getList();

    public void execute(String s) {

        if (s.isEmpty()) {
            System.out.println("Drop what?");
        } else {
            for (int i = 0; i < playerInventory.size(); i++) {
                if (playerInventory.get(i).getItemName().equals(s)) {
                    Items drop = playerInventory.get(i);
                    playerInventory.remove(i);
                    roomInventory.add(playerInventory.get(i));
                    System.out.println(drop.getItemName()+ " has dropped on the floor of this room.");
                }
            }
        }
    }
}

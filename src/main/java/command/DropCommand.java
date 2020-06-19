package command;

import Items.Items;
import Player.Player;
import Room.Room;
import Starter.Starter;
import Items.Inventory;

import java.util.ArrayList;

public class DropCommand implements Command {

    public void execute(String s, Room room, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {
        ArrayList<Items> roomInventory = room.getArrayInventory();
        ArrayList<Items> playerInventory = inventory.getList();
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

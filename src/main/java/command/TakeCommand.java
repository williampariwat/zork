package command;

import Items.Items;
import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public class TakeCommand implements Command {


    @Override
    public void execute(String s, Room room, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {
        ArrayList<Items> roomInventory = room.getArrayInventory();
        if(s.isEmpty()){
            System.out.println("Take what?");
        }else{
            for(int i = 0; i < roomInventory.size(); i++){
                if(roomInventory.get(i).getItemName().equals(s)){
                    inventory.addItem(roomInventory.get(i));
                    roomInventory.remove(i);
                }
            }
        }
    }
}

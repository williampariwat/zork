package command;

import Items.Items;
import Starter.Starter;

import java.util.ArrayList;

public class TakeCommand implements Command {
    //Take stuff and then you remove it from the list of that room
    private Starter starter;
    public ArrayList<Items> roomInventory = starter.getCurrentRoom().getArrayInventory();
    public ArrayList<Items> playerInventory = starter.getPlayerInventory().getList();

    @Override
    public void execute(String s) {
        if(s.isEmpty()){
            System.out.println("Take what?");
        }else{
            for(int i = 0; i < roomInventory.size(); i++){
                if(roomInventory.get(i).getItemName().equals(s)){
                    starter.getPlayerInventory().addItem(roomInventory.get(i));
                    roomInventory.remove(i);
                }
            }
        }
    }
}

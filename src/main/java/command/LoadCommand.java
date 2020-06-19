package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;
import com.sun.tools.javadoc.Start;

import java.util.ArrayList;

public class LoadCommand implements Command {

    private Starter starter;
    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, ArrayList<Starter> listOfSave ){
        for(int i = 0; i < starter.getListOfSave().size(); i++){
            if(starter.getListOfSave().get(i).getName().equals(s)){
                starter = starter.getListOfSave().get(i);
            }
        }
    }
}

package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;
import Starter.Main;

import java.util.ArrayList;

public class PlayCommand implements Command {

    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {
        if(s.isEmpty()){
            Starter game = new Starter();
            game.Starter();
        }
    }
}

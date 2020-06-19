package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public class ExitCommand implements Command{

    public void execute(String s, Room currentRoom, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {

    System.exit(0);

    }
}

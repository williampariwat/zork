package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public class SaveCommand implements Command {

    private Starter starter;
    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {
        Starter save = new Starter();
        save = starter;
        save.changeName(s);
        starter.getListOfSave().add(save);
    }
}

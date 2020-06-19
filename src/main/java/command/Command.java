package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public interface Command {

    void execute(String s, Room currentRoom, Player player, Inventory inventory,  ArrayList<Starter> listOfSave);


}

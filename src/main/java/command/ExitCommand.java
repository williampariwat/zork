package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;

public class ExitCommand implements Command{

    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean gameStatus, mapReader mapTracker) {

        System.exit(0);

    }

    @Override
    public Room getUpdatedRoom() {
        return null;
    }

    @Override
    public Player getUpdatedPlayer() {
        return null;
    }

    @Override
    public Inventory getUpdatedInventory() {
        return null;
    }


    @Override
    public boolean inGameCommand() {
        return false;
    }

    @Override
    public boolean getStartStatus() {
        return false;
    }

    @Override
    public mapReader getMapTracker() {
        return null;
    }

}

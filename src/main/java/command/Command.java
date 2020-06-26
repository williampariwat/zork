package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Command {

    void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader map) throws FileNotFoundException;

    Room getUpdatedRoom();

    Player getUpdatedPlayer();

    Inventory getUpdatedInventory();

    boolean inGameCommand();

    boolean getStartStatus();

    mapReader getMapTracker();

}

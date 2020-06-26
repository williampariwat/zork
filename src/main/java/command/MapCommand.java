package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapCommand implements Command {

    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    Boolean startStatus;
    mapReader mapTracker;

    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus,mapReader mapTracker) throws FileNotFoundException {

        if(s == null){
            if(mapTracker.getMapNum().equals("1")){
                File file = new File("/Users/wiliamh/Desktop/Work/Sophomore Year/Term III/Software Construction/Zork/MapArt/MapArt.txt");
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                }

                System.out.println("Current Room: "+currentRoom.getRoomName());
            }else if(mapTracker.getMapNum().equals("2")){
                File file = new File("/Users/wiliamh/Desktop/Work/Sophomore Year/Term III/Software Construction/Zork/MapArt/MapArt.txt");
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                }
            }

        }else{
            System.out.println("This command does not require second argument.");
        }
        this.currentRoom = currentRoom;
        this.playerStatus = player;
        this.currentInventory = inventory;
        this.startStatus = startStatus;
        this.mapTracker = mapTracker;
    }

    @Override
    public Room getUpdatedRoom() {
        return this.currentRoom;
    }

    @Override
    public Player getUpdatedPlayer() {
        return this.playerStatus;
    }

    @Override
    public Inventory getUpdatedInventory() {
        return this.currentInventory;
    }


    @Override
    public boolean inGameCommand() {
        return true;
    }

    @Override
    public boolean getStartStatus() {
        return this.startStatus;
    }

    @Override
    public mapReader getMapTracker() {
        return this.mapTracker;
    }


}

package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Starter.Starter;
import Starter.Main;

import java.util.ArrayList;

public class PlayCommand implements Command {
    Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    boolean startStatus;
    mapReader map;
    private mapReader firstMap = new mapReader("/Users/wiliamh/Desktop/Work/Sophomore Year/Term III/Software Construction/Zork/Maps/Map.txt","1");
    private mapReader secondMap = new mapReader("/Users/wiliamh/Desktop/Work/Sophomore Year/Term III/Software Construction/Zork/Maps/Map2.txt","2");
    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader map) {
        //Find a way to check if map Exist and then let the user pick the map from it.
        //Load the map

        if(s != null && !startStatus){

            if(s.equals("1")){

                firstMap.mapInitializer();
                setup(player, inventory, firstMap);


            }else if(s.equals("2")){
                secondMap.mapInitializer();;
                setup(player, inventory, secondMap);

            }else {
                System.out.println("Invalid map, please type again.");
                this.currentRoom = currentRoom;
                this.playerStatus = player;
                this.currentInventory = inventory;
                this.startStatus = false;
                this.map = map;
            }
        }else{
            System.out.println("Which map?");
            this.currentRoom = currentRoom;
            this.playerStatus = player;
            this.currentInventory = inventory;
            this.startStatus = false;
            this.map = map;
        }



    }

    private void setup(Player player, Inventory inventory, mapReader secondMap) {
        this.currentRoom = secondMap.getRoomMap("BATHROOM");
        this.startStatus = true;
        this.map = secondMap;
        this.playerStatus = player;
        this.currentInventory = inventory;
        Introduction welcome = new Introduction(this.playerStatus,this.currentRoom,this.currentInventory);
        welcome.shout();
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
        return false;
    }

    @Override
    public boolean getStartStatus() {
        return this.startStatus;
    }

    public mapReader getMapTracker(){
        return this.map;
    }
}

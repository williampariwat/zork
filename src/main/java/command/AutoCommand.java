package command;

import Items.Inventory;
import Map.mapReader;
import Player.Player;
import Room.Room;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoCommand implements Command
{   Room currentRoom;
    Player playerStatus;
    Inventory currentInventory;
    mapReader mapTracker;
    boolean startStatus;

    @Override
    public void execute(String s, Room currentRoom, Player player, Inventory inventory,boolean startStatus,mapReader mapTracker) throws FileNotFoundException {
        if(s != null) {
            FileInputStream fileInput = null;
            try {
                fileInput = new FileInputStream(s);
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
            Scanner sc;
            sc = new Scanner(fileInput);
            while (sc.hasNext()) {
                String[] cmd = sc.nextLine().split(" ");
                Command tmp = CommandFactory.getCommand(cmd[0]);
                if(tmp != null){
                    if (tmp.inGameCommand()) {
                        tmp.execute(cmd.length == 1 ? null: cmd[1],currentRoom,player,inventory,startStatus,mapTracker);
                        currentRoom = tmp.getUpdatedRoom();
                        player = tmp.getUpdatedPlayer();
                        inventory = tmp.getUpdatedInventory();
                        mapTracker = tmp.getMapTracker();
                    }
                }
            }
            sc.close();
        }else{
            System.out.println("Please used valid autopilot file.");
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

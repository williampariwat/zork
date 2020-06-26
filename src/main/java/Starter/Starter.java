package Starter;

import Items.Items;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Items.Inventory;
import command.Command;
import command.CommandFactory;
import command.Introduction;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Starter implements Serializable {
    public Items fist;
    public Room currentRoom;
    public Player player = new Player();
    public Inventory inventory = new Inventory(new ArrayList<Items>()); //FIx this
    private String name;
    private mapReader map;
    private boolean isPlaying = false;

    public void setStarter( Room currentRoom, Player player, Inventory inventory, boolean startStatus, mapReader map){
        this.currentRoom = currentRoom;
        this.player = player;
        this.inventory = inventory;
        this.isPlaying = startStatus;
        this.map = map;
    }

    public void Starter() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        fist = new Items("fist","weapon",5);
        inventory.addItem(fist);
        Introduction welcome = new Introduction(this.player,this.currentRoom,this.inventory);
        welcome.intro();

        while(true){

            System.out.print("> ");

            cmd = scanner.nextLine();
            String[] words = cmd.split(" ");

            Command command = CommandFactory.getCommand(words[0]);

            if(command != null && !isPlaying && !command.inGameCommand()){
                command.execute(words.length == 1 ? null : words[1], currentRoom, player,inventory, isPlaying,map);
                this.currentRoom = command.getUpdatedRoom();
                this.player =command.getUpdatedPlayer();
                this.inventory = command.getUpdatedInventory();
                this.isPlaying = command.getStartStatus();
                this.map = command.getMapTracker();
            }

            else if (command != null && isPlaying && command.inGameCommand()){

                command.execute(words.length == 1 ? null : words[1], currentRoom, player,inventory, isPlaying,map);
                this.currentRoom = command.getUpdatedRoom();
                this.player = command.getUpdatedPlayer();
                this.inventory = command.getUpdatedInventory();
                this.isPlaying = command.getStartStatus();
                this.map = command.getMapTracker();


            }else if (command != null && !isPlaying){
                System.out.println("Please pick a map before starting to type other command.");
            }else if(command != null && !command.inGameCommand() && isPlaying){
                System.out.println("The game is already started.");
            }else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public Inventory getPlayerInventory(){ return this.inventory;}

    public Player getPlayer(){
        return player;
    }


    public mapReader getMap(){
        return this.map;
    }


    public boolean getGameStatus(){
        return this.isPlaying;
    }




}

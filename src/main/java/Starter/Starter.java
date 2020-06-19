package Starter;

import Items.Items;
import Map.mapReader;
import Player.Player;
import Room.Room;
import Items.Inventory;
import command.Command;
import command.CommandFactory;
import command.Introduction;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Starter {
    public Items item;
    private mapReader mapReader;
    public Room currentRoom;
    public Player player = new Player();
    public Inventory inventory = new Inventory(new ArrayList<Items>()); //FIx this
    private String name;
    private ArrayList<Starter> listOfSave = new ArrayList<Starter>();


    public void Starter(){
        mapReader = new mapReader("/Users/wiliamh/Desktop/Work/Sophomore Year/Term III/Software Construction/Zork/Map.txt");
        mapReader.mapInitializer();
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        currentRoom = mapReader.getRoomMap("BATHROOM");
        Introduction welcome = new Introduction(player,currentRoom);
        welcome.shout();

        while(true){
            System.out.print("> ");
            cmd = scanner.nextLine();
            String[] words = cmd.split(" ");

            Command command = CommandFactory.getCommand(words[0]);

            if (command != null){
                command.execute(words.length == 1 ? null : words[1], currentRoom, player,inventory,listOfSave);
                //update room and all the stuff 
            }
        }
    }
//put everything in execute command.
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public Inventory getPlayerInventory(){ return inventory;}

    public Player getPlayer(){
        return player;
    }

    public void changeName(String nam){
        this.name = nam;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Starter> getListOfSave(){
        return listOfSave;
    }


}

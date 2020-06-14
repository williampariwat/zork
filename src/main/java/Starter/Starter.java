package Starter;

import Items.Items;
import Player.Player;
import Room.Room;
import Items.Inventory;
import command.Command;
import command.CommandFactory;
import command.Introduction;

import java.util.ArrayList;
import java.util.Scanner;

public class Starter {
    public Items item;
    public Room currentRoom = new Room();
    public Player player = new Player();
    public Inventory inventory = new Inventory(); //FIx this 
    public String name;
    public ArrayList<Starter> listOfSave = new ArrayList<Starter>();


    public void Starter(){
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        this.name = "default";
        Introduction welcome = new Introduction(player,currentRoom);

        welcome.shout();

        while(true){
            System.out.println("> ");
            cmd = scanner.nextLine();
            String[] words = cmd.split(" ");

            Command command = CommandFactory.getCommand(words[0]);

            if (command != null){
                command.execute(words.length == 1 ? null : words[1]);
            }
        }
    }

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

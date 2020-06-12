package Starter;

import Items.Items;
import Player.PlayerHealth;
import Room.Room;
import Items.Inventory;
import command.Command;
import command.CommandFactory;
import command.Introduction;

import java.util.Scanner;

public class Starter {
    private Items item;
    private Room currentRoom;
    private PlayerHealth health = new PlayerHealth();

    private Inventory inventory;
    public void Starter(){
        Scanner scanner = new Scanner(System.in);

        String cmd = "";

        Introduction welcome = new Introduction(health,currentRoom);

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
}

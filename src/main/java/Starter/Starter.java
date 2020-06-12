import Items.Items;
import Player.Health;
import Room.Room;
import Items.Inventory;
import command.Command;
import command.CommandFactory;
import command.Introduction;

import java.util.Scanner;

public class Starter {
    private Items item;
    private Room currentRoom;
    private Health health = new Health();

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
}

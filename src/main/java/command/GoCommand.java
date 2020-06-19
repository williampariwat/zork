package command;

import Items.Inventory;
import Player.Player;
import Room.Room;
import Starter.Starter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoCommand implements Command {

    //    public Starter starter = new Starter();
//    public Room currentRoom = starter.getCurrentRoom();
    String[] directions = {"north", "south", "east", "west"};
    List<String> dir = Arrays.asList(directions);

    @Override
    public void execute(String direction, Room room, Player player, Inventory inventory, ArrayList<Starter> listOfSave) {
        if (direction == null) {
            System.out.println("Go where?");
            return;
        } else {

            if (!dir.contains(direction)) {
                System.out.println("Go where?");
                return;
            } else {

                Room nextRoom = room.nextRoom(direction);

                if (nextRoom == null) {
                    System.out.println("This is the end of the map");
                } else {
                    room = nextRoom;
                    System.out.println(room.longDescription());
                    room.getMonsters();
                    System.out.println("Items on the floor: ");
                    room.getRoomInventory();

                }
            }
        }

        //Fix the room
    }
}

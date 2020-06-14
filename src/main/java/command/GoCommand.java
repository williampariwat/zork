package command;

import Room.Room;
import Starter.Starter;

public class GoCommand implements Command {

    private Starter starter;
    private Room currentRoom = starter.getCurrentRoom();
    @Override
    public void execute(String direction) {

        if(direction.isEmpty()){
            System.out.println("Go where?");
            return;
        }

        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null){
            System.out.println("This is the end of the map");
        }else{
            currentRoom = nextRoom;
//            System.out.println(currentRoom.longDescription());
            currentRoom.getMonsters();
        }
    }
}

package command;

public class GoCommand implements Command {


    @Override
    public void execute(String secondWord) {
        Room nextRoom = currentRoom.nextroom(secondWord);

        if (nextRoom == null){
            System.out.println("This is the end of the map");
        }else{
            currentRoom = nextRoom;
            System.out.println(currentRoom.longDescription());
        }
    }

    public void shout(){
        System.out.println("Go where?");
    }
}

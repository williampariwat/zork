package Map;


import Room.Room;

import java.util.Scanner;

public class LoadMap {
    private String fileDir;
    private String startLocation;
    private mapReader mapRead;
    private Room currentRoom;
    public LoadMap(String fileDir, String startLocation){

        this.fileDir = fileDir;
        this.startLocation = startLocation;
    }

    public LoadMap(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file path of your maps: ");

        String filePath = scanner.nextLine();

        System.out.println("Please enter the stating location of this map: ");

        String start = scanner.nextLine();
        try{
            mapRead = new mapReader(filePath);
            currentRoom = mapRead.getRoomMap(start);
        }
    }
}

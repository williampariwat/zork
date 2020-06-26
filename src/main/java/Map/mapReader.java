package Map;

import Room.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class mapReader {

    String fileName;
    String num;
    private HashMap<String, Room> roomMap = new HashMap<String, Room>();

    public mapReader(String fileName, String num) {
        this.fileName = fileName;
        this.num = num;
    }

    public void mapInitializer() {
        Scanner scanRoom;
        try {
            HashMap<String, HashMap<String, String>> exits = new HashMap<String, HashMap<String, String>>();
            File file = new File(fileName);
            scanRoom = new Scanner(file);
            while (scanRoom.hasNext()) {
                Room room = new Room();
                //Name
                String roomName = scanRoom.nextLine();
                //Trimming the roomName
                room.setRoomName(roomName.split(":")[1].trim());
                // Read the Description
                String roomDescription = scanRoom.nextLine();

                room.setDescription(roomDescription.split(":")[1].replaceAll("<br>", "\n").trim());
                //Set room exits for each room;
                String roomExits = scanRoom.nextLine();

                String[] rooms = roomExits.split(":")[1].split(",");
//                System.out.println(Arrays.toString(rooms));


                //Read items in the file
                String roomItems = scanRoom.nextLine();
//                System.out.println(Arrays.toString(roomItems.split(":")[1].split(",")));
                room.setRoomInventory(roomItems.split(":")[1].split(","));
                //Read monsters in the file
                String roomMonsters = scanRoom.nextLine();
                room.setRoomMonster(roomMonsters.split(":")[1].split(","));


//                System.out.println(Arrays.toString(rooms));

                HashMap<String, String> temp = new HashMap<String, String>();

                for (String s : rooms) {
//                    System.out.println(s);
                    temp.put(s.split("-")[0].trim(), s.split("-")[1]);
                }


                exits.put(roomName.substring(10).trim().toUpperCase().replaceAll(" ", "_"), temp);

                roomMap.put(roomName.toUpperCase().substring(10).trim().replaceAll(" ", "_"), room);
            }

            for (String key : roomMap.keySet()) {
                Room roomTemp = roomMap.get(key);
                HashMap<String, String> tempExits = exits.get(key); //get set of exits for each room
                for (String direction : tempExits.keySet()) {

                    String roomName2 = tempExits.get(direction.trim());
                    Room exitRoom = roomMap.get(roomName2.toUpperCase().replaceAll(" ", "_"));
                    roomTemp.setExit(direction.trim().charAt(0), exitRoom);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public Room getRoomMap(String room) {
        return this.roomMap.get(room);

    }

    public String getMapNum(){
        return this.num;
    }


}

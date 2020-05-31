package Map;

import Room.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class mapReader {

    String fileName;
    private HashMap<String, Room> roomMap = new HashMap<String, Room>();

    public mapReader(String fileName){
        this.fileName  = fileName;
    }

    public void mapInitializer(String fileName){
        Scanner scanRoom;
        try{
            HashMap<String, HashMap<String,String>> exits = new HashMap<String, HashMap<String, String>>();
            scanRoom = new Scanner(new File(fileName));
            while(scanRoom.hasNext()){
                Room room = new Room();
                //Name
                String roomName = scanRoom.nextLine();
                //Trimming the roomName
                room.setRoomName(roomName.split(":")[1].replaceAll("<br>","\n".trim()));

                //Set room exits for each room;
                String roomExits = scanRoom.nextLine();

                String[] rooms = roomExits.split(":")[1].split(",");

                HashMap<String, String> exitRooms = new HashMap<String, String>();

                for(String s : rooms){
                    exitRooms.put(s.split("-")[0].trim(),s.split("-")[1]);
                }

                exits.put(roomName.substring(10).trim().toUpperCase().replaceAll(" ","_"),exitRooms);

                roomMap.put(roomName.toUpperCase().substring(10).trim().replaceAll(" ",","),room);
            }

            for (String key : roomMap.keySet()){
                Room roomTemp = roomMap.get(key);
                HashMap<String,String> tempExits = exits.get(key); //get set of exits for each room
                for (String direction : tempExits.keySet()){

                    String roomName2 = tempExits.get(direction.trim());
                    Room exitRoom = roomMap.get(roomName2.toUpperCase().replaceAll(" ","_"));
                    roomTemp.setExit(direction.trim().charAt(0),exitRoom);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            }


    }

    public Room getRoomMap(String room){
        return roomMap.get(room);

}

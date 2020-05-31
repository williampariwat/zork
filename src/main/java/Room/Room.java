package Room;


import Items.Items;

import java.util.*;

public class Room {
    private Items item;
    private String roomName;
    private String description;

    private ArrayList<Items> itemList;
    private HashMap<String, Room> exits;

    public Room(String description){
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public Room(){
        roomName = "DEFAULT ROOM";
        description = "DEFAULT DESCRIPTION";
        itemList = new ArrayList<Items>();
        exits = new HashMap<String, Room>();
    }

    public void setExit(char direction, Room r) throws Exception {
        String dir="";
        switch (direction){
            case 'E': dir = "east"; break;
            case 'W': dir = "west"; break;
            case 'S': dir = "south"; break;
            case 'N': dir = "north"; break;
            case 'U': dir = "up"; break;
            case 'D': dir = "down";break;
            default: throw new Exception("Invalid Direction");
        }

        exits.put(dir,r);
    }


    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down){
        if(north != null)
            exits.put("north",north);
        if(east != null)
            exits.put("east",east);
        if(south != null)
            exits.put("south",south);
        if(west != null)
            exits.put("west",west);
        if(up != null)
            exits.put("up",up);
        if(down != null)
            exits.put("down",down);
    }

    public String exitString(){
        String returnString = "Exits:";
            Set keys = exits.keySet();
        for(Iterator iter = keys.iterator(); iter.hasNext(); ){
            returnString += " " + iter.next();
        }
        return returnString;
    }


    public String shortDescription(){
        return "Room: " +roomName + "\n\n" + description;
    }

    public String longDescription(){
        return "Room: " + roomName + "\n\n" + description + "\n" + exitString();
    }

    public Room nextRoom(String direction){
        return exits.get(direction);
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public ArrayList<Items> getRoomInventory(){
        return itemList;
    }

    public void setRoomInventory(String[] items){
        List<String> stringItems = Arrays.asList(items);
        ArrayList<Items> realList = new ArrayList<Items>(stringItems.size());
        for(int i = 0; i < realList.size();i++){
            if(stringItems.get(i).equals("none")){
                i++;
            }else{
                realList.add(item.stringToItem(stringItems.get(i)));
            }
        }
        this.itemList = realList;
    }



}

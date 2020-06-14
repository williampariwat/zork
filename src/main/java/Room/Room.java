package Room;


import Items.Items;
import Monsters.Monster;

import java.lang.reflect.Array;
import java.util.*;

public class Room {
    private Items item;
    private String roomName;
    private String description;
    private Monster monster;

    private ArrayList<Items> itemList;
    private ArrayList<Monster> monstersList;
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
        monstersList = new ArrayList<Monster>();
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

    public void getRoomInventory(){
        System.out.println("In this room, you found....");
        System.out.println(itemList.toString());
    }

    public ArrayList<Items> getArrayInventory(){
        return itemList;
    }

    public void getMonsters() {
        if (!this.monstersList.isEmpty()) {
            System.out.println("!!!!!!!!!!!");
            System.out.println("There is a monster in this room !");
            System.out.println(this.monstersList.toString());
        }
    }

    public ArrayList<Monster> getMonstersList(){
        return monstersList;
    }

    public String getDescription(){

        return description;
    }

    public void setDescription(String description){
        this.description = description;
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

    public void setRoomMonster(String[] monsters){
        List<String> stringMonsters = Arrays.asList(monsters);
        ArrayList<Monster> realList = new ArrayList<Monster>(stringMonsters.size());
        for(int i = 0; i < realList.size(); i++){
            if(stringMonsters.get(i).equals("none")){
                i++;
            }else{
                realList.add(monster.stringToMonster(stringMonsters.get(i)));
            }
        }
        this.monstersList = realList;
    }



}

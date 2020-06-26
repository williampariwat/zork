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
            default: throw new Exception("Invalid Direction");
        }

        exits.put(dir,r);
    }


    public void setExits(Room north, Room east, Room south, Room west){
        if(north != null)
            exits.put("north",north);
        if(east != null)
            exits.put("east",east);
        if(south != null)
            exits.put("south",south);
        if(west != null)
            exits.put("west",west);
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
        return (Room) exits.get(direction);
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
    }

    public void getRoomInventory(){
        if(!itemList.isEmpty()) {
            System.out.println("In this room, you found....");
            System.out.println("  -> "+itemList.get(0).getItemName());
        }else{
            System.out.println("Nothing is in this room ");
        }
    }

    public ArrayList<Items> getArrayInventory(){
        return this.itemList;
    }

    public void getMonstersDialogue() {
        if (!this.monstersList.get(0).getMonsterName().equals("None")) {
            System.out.println("!!!!!!!!!!!");
            System.out.println("There is a monster in this room !");
            System.out.println(this.monstersList.get(0).getMonsterName());
        }
    }

    public Monster getMonster(){
        return this.monstersList.get(0);
    }

    public ArrayList<Monster> getMonstersList(){
        return monstersList;
    }

    public String getDescription(){

        return description;
    }

    public String getRoomName(){
        return this.roomName;
    }

    public void setDescription(String description){
        this.description = description;
    }



    public void setRoomInventory(String[] items){

        ArrayList<Items> realList = new ArrayList<Items>(items.length);
        Items temp = new Items(items[0].trim(),items[1].trim(),Integer.valueOf(items[2].trim()));
        realList.add(temp);
        this.itemList = realList;

    }


    public void setRoomMonster(String[] monsters){
        ArrayList<Monster> realList = new ArrayList<Monster>(monsters.length);
        Monster temp = new Monster(monsters[0].trim(),Integer.valueOf(monsters[1].trim()),Integer.valueOf(monsters[2].trim()));
        realList.add(temp);
        this.monstersList = realList;
    }

    public boolean isInside(String item){
        return(this.itemList.get(0).getItemName().equals(item));
    }




}

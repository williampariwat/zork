package command;

import Items.Inventory;
import Player.Player;
import Room.Room;

public class Introduction {
    Player health;
    Room currentRoom;
    Inventory inventory;
    public Introduction(Player health, Room currentRoom, Inventory inventory){
        this.health = health;
        this.currentRoom = currentRoom;
        this.inventory = inventory;
    }
    public  void intro(){
        System.out.println("Use command -PLAY- to pick a map, then type a number after the command");
        System.out.println("Map 1: Mysterious Aquarium");
        System.out.println("Map 2: Aussie Aqua World");
    }
    public void shout() {
        System.out.println();
        System.out.println("Welcome to Zork.");
        System.out.println("You will find shell in different places. Collect all of them to win the game.");
        System.out.println("Here's the catch, you need to kill all the monster. Or else! You are not able to collect the shell.");
        System.out.println("When you have all the shells, type win and press enter, you win the game!");
        System.out.println("You must be in the Shark Room to type the -Win- Command.");
        System.out.println("Hahaha, you are lucky. I've granted you the first shell....");
        System.out.println("Keep it and find the rest of them.");
        System.out.println();
        System.out.println("You will begin in the Bathroom. Good luck.");
        System.out.println(currentRoom.longDescription());
        inventory.addItem(currentRoom.getArrayInventory().get(0));
        currentRoom.getArrayInventory().remove(0);

    }

}

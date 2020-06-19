package command;

import Player.Player;
import Room.Room;

public class Introduction {
    private Player health;
    private Room currentRoom;
    public Introduction(Player health, Room currentRoom){
        this.health = health;
        this.currentRoom = currentRoom;
    }
    public void shout() {
        System.out.println();
        System.out.println("Welcome to Zork.");
        System.out.println("You will find shell in different places. Collect all of them to win the game.");
        System.out.println("When you have all the shells, type win and press enter, you win the game!");
        System.out.println("You must be in the Shark Room to type the -Win- Command.");
        System.out.println();
        System.out.println("You will begin in the Bathroom. Good luck.");
//        health.getFoodBar();
        System.out.println(currentRoom.longDescription());
    }

}

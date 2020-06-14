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
        System.out.println("You will find codes in different places. Write them down and remember them.");
        System.out.println("When you have all 9 words (don't forget punctuation), type enter code, and submit your answer, you win the game!");
        System.out.println("You must be in the ...... to submit your final answer.");
        System.out.println();
        System.out.println("You will begin /// in the ///. Good luck.");
//        health.getFoodBar();
//        System.out.println(currentRoom.longDescription());
    }

}

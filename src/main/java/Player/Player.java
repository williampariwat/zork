package Player;

import Items.Inventory;
import Items.Items;

import java.util.ArrayList;

public class Player
{
    private int healthBar;
    private Inventory inventory;

    public Player(){
        healthBar = 100;
        inventory = new Inventory(new ArrayList<Items>());
    }


    public void attacked(int damage){
       this.healthBar = this.healthBar - damage;
    }

    public int getHealthBar(){
        return this.healthBar;
    }

    public void increaseHP(int hp){
        this.healthBar = this.healthBar + hp;
    }

    }

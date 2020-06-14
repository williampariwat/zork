package Player;

import Items.Inventory;
import Items.Items;

import java.util.ArrayList;

public class Player
{
    private Hungerlevel hungerLevel;
    private int healthBar;
    private Inventory inventory;

    public Player(){
        hungerLevel = new Hungerlevel();
        healthBar = 100;
        inventory = new Inventory(new ArrayList<Items>());
    }

    public Hungerlevel getFoodBar(){
        return hungerLevel;
    }

    public boolean decrease(){
        hungerLevel.decrease();
        return hungerLevel.decrease();
    }

    public void attacked(int damage){
       healthBar = healthBar - damage;
    }

    public int getHealthBar(){
        return healthBar;
    }

    }

package Monsters;

import javax.xml.stream.Location;
import java.util.Random;

public abstract class Monster {

    protected static final Random RANDOM = new Random();

    private Integer[] location;

    private int HP = 100;

    private int attackDamage;

    private boolean alive = true;

    public boolean isAlive(){
        return alive;
    }
    

    public void setDead(){
        alive = false;
        if(location != null){
            location = null;
            HP = 100;
        }
    }

    public void initialize(Location location){
        setLocation(location);
        setAttackDamage();
    }

    public void setAttackDamage(){
        attackDamage =  RANDOM.nextInt(HP/2);
    }

    protected void isDead(){
        if(HP <= 0){
            setDead();
        }
    }



}

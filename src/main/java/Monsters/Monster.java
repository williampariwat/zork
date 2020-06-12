package Monsters;

import javax.xml.stream.Location;
import java.util.Random;

public abstract class MonsterHealth {


    private int healthBar = 100;

    private int attackDamage;
    private String MonsterName;
    

    public void Monster(String name, String i\){
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

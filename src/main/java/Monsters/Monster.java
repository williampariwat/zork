package Monsters;

import java.util.ArrayList;
import java.util.Random;

public class Monster {


    private int healthBar;
    private int attackDamage;
    private String monsterName;
    private Random r = new Random();


    public Monster(String monsterName, int attackDamage, int HP){
        this.monsterName = monsterName;
        this.healthBar = HP;
        this.attackDamage = attackDamage;
    }

    public String getMonsterName(){ return monsterName; }

    public int getAttackDamage(){
        return this.attackDamage;
    }

    public int getRandomizedAttackDamage(){
        int low = 5;
        int high = attackDamage + 1;

        return r.nextInt(high-low)+low;
    }
    public int getHealthBar(){ return this.healthBar; }


    public void removeMonster(Monster monster, ArrayList<Monster> allMonsters){
        for(int i = 0; i < allMonsters.size(); i++){
            if(allMonsters.get(i).equals(monster)){
                allMonsters.remove(i);
            }
        }
    }

    public boolean isMonster(String s){
        if(s.equals(monsterName)){
          return true;
        }else{
            return false;
        }
    }
    public void attacked(int damage){
        this.healthBar = this.healthBar - damage;
    }


    public Monster stringToMonster(String string){
        Monster monster;
        if(!isMonster(string)){
            return null;
        }else{
            monster = new Monster(string,attackDamage,healthBar);
            return monster;
        }
    }

    public boolean isDead(){
        return (this.healthBar <= 0);
    }

    public boolean noMonster(){
        return this.monsterName.equals("None");
    }




}

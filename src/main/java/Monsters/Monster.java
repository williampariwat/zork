package Monsters;

import java.util.ArrayList;

public class Monster {


    private int healthBar;
    private int attackDamage;
    private String monsterName;


    public Monster(String monsterName, int attackDamage, int HP){
        this.monsterName = monsterName;
        this.healthBar = HP;
        this.attackDamage = attackDamage;
    }

    public String getMonsterName(){ return monsterName; }

    public int getAttackDamage(){return attackDamage; }

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
        healthBar = healthBar - damage;
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
        return this.healthBar < 100;
    }



}

package Items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Items> inventory;
    private Items item;
    private int tokenCount = 1;
    private int MaxInventory = 7;



    public Inventory(ArrayList<Items> inventory) {
        this.inventory = inventory;
    }

    public Inventory(){
        for(int i = 0; i < inventory.size(); i++){
            if(this.inventory.get(i).getItemName().split(" ")[1].equals("Shell")){
                tokenCount++;
            }
        }
    }


    public boolean isInside(String anItem) {
        for (int i = 0; i < inventory.size(); i++) {
            if (this.inventory.get(i).getItemName().equals(anItem)) {
                return true;
            }
        }
        return false;
    }

    public void addItem(Items item){
        inventory.add(item);
    }

    public void removeItem(String item){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemName().equals(item)){
                this.inventory.remove(i);
            }
        }
    }


    public void printInventory(){
        if(inventory.size() == 0){
            System.out.println("Nothing is inside your inventory!");
        }else{

            for(int i = 0; i< inventory.size(); i++){
                System.out.println("  -> "+inventory.get(i).getItemName());
            }
        }
    }

    public int getSize(){
        return this.inventory.size();
    }

    public Items getItem(String item){
        for(int i = 0; i < inventory.size();i++ ) {
            if (inventory.get(i).getItemName().equals(item)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    public int getAttackPower(){
        int power = 0;
        for(int i = 0; i < inventory.size();i++){
            if(inventory.get(i).isWeapon()){
                power = power + inventory.get(i).getWeight();
            }
        }
        return power;
    }

    public ArrayList<Items> getList(){
        return this.inventory;
    }

    public boolean containsWeapon(){
        for(int i = 0; i < inventory.size(); i++){
            if(this.inventory.get(i).isWeapon()){
                return true;
            }
        }
        return false;
    }

    public int totalToken(){
        return tokenCount;
    }

    public boolean isFull(){
        return getSize() >= MaxInventory;
    }
}

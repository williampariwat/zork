package Items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Items> inventory;
    private Items item;

    public Inventory(ArrayList<Items> inventory) {
        this.inventory = inventory;
    }

    public boolean isInside(Items anItem) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(anItem)) {
                return true;
            }
        }
        return false;
    }

    public void addItem(Items item){
        inventory.add(item);
    }

    public void removeItem(Items item){
        for(int i = 0; i < inventory.size(); i++){
            if(item.getItemName().equals(inventory.get(i).getItemName()) && item.getItemType().equals(inventory.get(i).getItemType())){
                inventory.remove(i);
            }
        }
    }

    public void printInventory(){
        if(inventory.size() == 0){
            System.out.println("Nothing is inside your inventory!");
        }else{

            for(int i = 0; i< inventory.size(); i++){
                System.out.println(inventory.get(i).toString());
            }
        }
    }

    public int numItems(){
        return inventory.size();
    }


}

package Items;

import java.util.ArrayList;

public class Items {
    private String itemName;
    private double weight;
    private String itemType;
    private boolean isWeapon;
    private boolean isToken;
    private boolean isMedicine;


    public Items(String itemName, String itemType, int weight){
        super();
        this.itemName = itemName;
        this.itemType = itemType;
        this.weight = weight;

        isWeapon = itemType.equals("weapon");
        isMedicine =  itemType.equals("potion");
        isToken = itemType.equals("token");
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemType(){
        return itemType;
    }

    public double getWeight(){
        return weight;
    }

//    public void removeItem(Items item, ArrayList<Items> roomItems){
//        for(int i = 0; i < roomItems.size(); i++){
//            if(roomItems.get(i).equals(item))
//                roomItems.remove(i);
//        }
//    }

    public boolean isItem(String aString){
        if(aString.equals(itemName))
            return true;
        else
            return false;
    }

    public boolean isWeapon(){
        return isWeapon;
    }

    public Items stringToItem(String aString , String itemType, int weight){
//        System.out.println(aString + itemType + String.valueOf(weight));
        Items item;
        if(!isItem(aString)){
            return null;
        }else{
            item = new Items(aString, itemType, weight);
            return item;
        }

    }

}

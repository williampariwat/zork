package Player;

public class Hungerlevel {

    private static final int maxHungerSlot = 20;
    private String[] hunger;

    public Hungerlevel(){
        hunger = new String[maxHungerSlot];

        for (int i = 0; i < maxHungerSlot; i++){
            hunger[i] = "x";
        }
    }

    public boolean increase() {
        boolean bool = false;
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < maxHungerSlot; j++){
                if(hunger[j].equals("Y")){
                    hunger[j] = "x";
                    i = 00;
                    bool = true;
                }
            }
        }
        printHungerlevel();
        return bool;
    }

    public boolean decrease(){
        boolean bool = true;
        if(hunger[maxHungerSlot - 1].equals("x")){
            hunger[maxHungerSlot-1] = "Y";
            return true;
        }else{
            for(int i = 0; i < maxHungerSlot; i++){
                if(hunger[i].equals("Y")){
                    if(i != 0){
                        hunger[i-1] = "Y";
                        bool = true;
                        return bool;
                    }else{
                        bool = false;
                        return bool;
                    }
                }
            }
        }
        hunger[0] = "Y";
        bool = false;
        return bool;
    }

    public void printHungerlevel(){
        System.out.println("Hunger Bar: ");
        for(int i = 0; i < maxHungerSlot; i++){
            System.out.println("{"+hunger[i] +"}");
        }
        System.out.println("");
    }



}

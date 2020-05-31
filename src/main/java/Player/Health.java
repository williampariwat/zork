package Player;

public class Health
{
    private FoodBar f;
    private int healthBar;

    public Health(){
        f = new FoodBar();
        healthBar = 100;
    }

    public FoodBar getFoodBar(){
        return f;
    }

    public boolean decrease(){
        f.decrease();
        return f.decrease();
    }

    public void attacked(int damage){
       healthBar = healthBar - damage;
    }

    public int getHealthBar(){
        return healthBar;
    }
}

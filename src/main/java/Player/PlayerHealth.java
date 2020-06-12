package Player;

public class Health
{
    private Hungerlevel hungerLevel;
    private int healthBar;

    public Health(){
        hungerLevel = new Hungerlevel();
        healthBar = 100;
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

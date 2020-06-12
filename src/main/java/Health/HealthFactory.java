package Health;


public class HealthFactory {
    private int healthBar;

    public HealthFactory(){
        healthBar = 100;
    }

    public void attacked(int damage){
        healthBar = healthBar - damage;
    }

    public int getHealthBar(){
        return healthBar;
    }

}

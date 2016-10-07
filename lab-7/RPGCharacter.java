import java.util.Random;

public abstract class RPGCharacter {

    private String name;
    private int hp;
    private Random rand = new Random();

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public RPGCharacter(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public abstract int attack(int choice);

    public int takeDamage(int damage) {
        hp -= damage;
        return hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {return hp;}

    public void setHp(int hp) {
        this.hp = hp;
    }

}

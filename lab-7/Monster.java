public class Monster extends RPGCharacter{
    private int attackDamage;

    public Monster(String name, int hp, int attackDamage) {
        super(name, hp);
        this.attackDamage = attackDamage;
    }

    public int attack(int choice) {
        if(randInt(1, 100) <= 40){
            System.out.printf("%s healed him self while attacking!!\n", getName());
            setHp(getHp() + 10);
        }
        return attackDamage;
    }

    public String toString() {
        return "RPGCharacter{" +
                "name = '" + getName() + '\'' +
                ", hp = " + getHp() +
                '}';
    }
}

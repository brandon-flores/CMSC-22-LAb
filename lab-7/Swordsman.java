import java.util.Scanner;

public class Swordsman extends Hero {

  private static final int BASE_ATTACK = 15;
  private static final int ARMOR = 15;
  private static final int EVASIVENESS = 20;

  public Swordsman(String name, int hp, int type) {super(name, hp, type);}

  public int attack(int choice) {
    if(skill()){
      int skill;
      if(choice == 1){
        skill = doSkill();
        if(skill == 1) {
          System.out.println("");
          setMp(getMp() - 3);
          return BASE_ATTACK * 3;
        }
        if(skill == 2) {
          System.out.println("A glowing light engulfs you\nYou feel your wounds heal and your fatigue lessen");
          setMp(getMp() - 3);
          setHp(getHp() + 40);
          return 0;
        }
        if(skill == 3) {
          System.out.println("You dash forth, doing a great deal of damage to the creature and yourself");
          setMp(getMp() - 5);
          setHp(getHp() - 30);
          return BASE_ATTACK * 5;
        }
        if(skill == 1764) {
          System.out.println("The air chills as the creature gazes at you in fear\n");
          System.out.println("Your sword glows a dark blue hue as you draw it\n");
          System.out.println("The creature attempts to run, but it is too late\n");
          System.out.println("There is no escaping death");
          return 9999999;
        }
    }
  }
  else{ System.out.println("Can't use skill!"); }
  return BASE_ATTACK;
  }

  public int takeDamage(int damage) {
    if(randInt(1, 100) <= EVASIVENESS){
      System.out.println("You dodged the attack!");
      return super.takeDamage(0);
    }
    damage -= ARMOR;
    return super.takeDamage(damage);
  }
}

import java.util.Scanner;

public class Archer extends Hero{

  private static final int BASE_ATTACK = 15;
  private static final int ARMOR = 2;
  private static final int EVASIVENESS = 40;

  public Archer(String name, int hp, int type) {super(name, hp, type);}

  public int attack(int choice) {
    if(skill()){
      int skill;
      if(choice == 1){
      	skill = doSkill();
        if(skill == 1) {
          System.out.println("You draw your bow and take a breath\nThere is nothing but the creature in your sights\n");
          setMp(getMp() - 4);
          return BASE_ATTACK * 3;
        }
        if(skill == 2) {
          System.out.println("The sky opens forth\nThe smell of Iron fills the air\n");
          setMp(getMp() - 5);
          setHp(getHp() - 30);
          return BASE_ATTACK * 5;
        }
        if(skill == 3) {
          System.out.println("A glowing light engulfs you\nYou feel your wounds heal and your fatigue lessen");
          setMp(getMp() - 3);
          setHp(getHp() + 40);
          return 0;
        }
        if(skill == 1764) {
          System.out.println("The sky darkens and you draw your bow\n");
          System.out.println("The sky openns and you see the goddess smiling down on you\n");
          System.out.println("The creature attempts to run, but it is too late\n");
          System.out.println("There is no escaping death");
          return 9999999;
        }
      }
    }
    else {System.out.println("Can't use skill!");}
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
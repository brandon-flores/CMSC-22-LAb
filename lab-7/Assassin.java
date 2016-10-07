import java.util.Scanner;

public class Assassin extends Hero{

  private static final int BASE_ATTACK = 20;
  private static final int ARMOR = 4;
  private static final int EVASIVENESS = 30;

  public Assassin(String name, int hp, int type) {super(name, hp, type);}

  public int attack(int choice) {
    if(skill()){
      int skill;
      if(choice == 1){
        skill = doSkill();
        if(skill == 1) {
          System.out.println("Your blood-red knife pierces the beasts flesh\n");
          System.out.println("You feel the life force drain for it, and fill you\n");
          setMp(getMp() - 3);
          setHp(getHp() + 25);
          return 0;
        }
        if(skill == 2) {
          System.out.println("The monster recoils in pain");
          setMp(getMp() - 4);
          return BASE_ATTACK * 3;
        }
        if(skill == 3) {
          System.out.println("The knife pierces it's body as it strikes back at you in pain");
          setMp(getMp() - 5);
          setHp(getHp() - 30);
          return BASE_ATTACK * 5;
        }
        if(skill == 1764) {
          System.out.println("Chains of blood coil around the screaming beast\n");
          System.out.println("The fields clear as more and more surround it\n");
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
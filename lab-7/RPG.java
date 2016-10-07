import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPG {
  
  private Random rand = new Random();
  
  public RPG() {
    this.rand = new Random();
  }

  public String getRandomMonsterName() {
    String[] adjectives = {"Green", "Slimy", "Bloody", "Smelly"};
    String[] monsters = {"Ogre", "Elf", "Giant", "Teacher"};
    List<String> adjs = Arrays.asList(adjectives);
    List<String> mons = Arrays.asList(monsters);
    
    return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
  }
  
  public int randInt(int min, int max) {
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }
  
  public void sleep(int x) {
    try {
      Thread.sleep(x);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
  
  public boolean duel(RPGCharacter attacker, RPGCharacter defender, int turn) {
    int choice = 0;
    if(turn % 2 != 0){
      do{
        System.out.println("Use skill? [1] YES      [2] NO");
        Scanner num = new Scanner(System.in);
        choice = num.nextInt();
        if(choice == 1 || choice == 2) break;
        else System.out.println("Enter a valid option!");
      }while(true);
    }
    int damage = attacker.attack(choice);
    System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
    sleep(2500);
    int remHp = defender.takeDamage(damage);
    if (remHp <= 0) {
      System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
      return true;
    }
    return false;
  }
  
  public static void main(String[] args) {
    System.out.print("Enter your hero's name: ");
    Scanner scan = new Scanner(System.in);
    String name = scan.next();
    int classNumber;
    do{
      System.out.println("\nChoose your class: \n1 - Archer \n2 - Swordsman \n3 - Assassin");
      System.out.println("Press number of your chosen class: ");
      Scanner num = new Scanner(System.in);
      classNumber = num.nextInt();
      if(classNumber >= 1 && 2 >= classNumber) break;
      System.out.println("Enter a valid option!");
    }while(true);

    
    RPG rpg = new RPG();
    RPGCharacter hero = new Archer(name, 150, 1);;
    if(classNumber == 1){
      hero = new Archer(name, 150, 1);
      System.out.println("You have chosen an Archer!");
    }
    if(classNumber == 2){
      hero = new Swordsman(name, 300, 2);
      System.out.println("You have chosen an Swordsman!");
    }
    if(classNumber == 3){
      hero = new Assassin(name, 200, 3);
      System.out.println("You have chosen an Assassin!");
    }

    RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), 250, 25);
    
    System.out.println("<====== START ======>");
    System.out.printf("%s\nVS\n%s\n", hero, monster);
    
    int count = 0;
    int turn = 0;
    boolean flag = false;
    while (true) {
      System.out.println("\n== round " + ++count);
      boolean heroVsMonster = rpg.duel(hero, monster, ++turn);
      if (heroVsMonster) break;
      boolean monsterVsHero = rpg.duel(monster, hero, ++turn);
      if (monsterVsHero){
        flag = true;
        break;
      }
      
      System.out.printf("%s\n%s\n", hero, monster);
    }
    System.out.printf("%s\n%s\n", hero, monster);

    if(flag){
      System.out.println("YOU LOSE!");
    }else{
      System.out.println("YOU WIN!");
    }
  }
}

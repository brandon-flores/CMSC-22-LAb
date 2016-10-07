import java.util.Scanner;

public abstract class Hero extends RPGCharacter {
    private int mp = 15;
    private int type;

    public Hero(String name, int hp, int type) {
        super(name, hp);
        this.type = type;
    }

    public boolean skill() {return mp >= 3 ? true : false;}

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    public int doSkill(){
        int skill;
        do{
            if(type == 1){System.out.println("Skill: [1]Hawkeye     [2] A Rain Of Steel     [3] Artemis' Blessing");}
            if(type == 2){System.out.println("Skill: [1] Parry     [2] Holy Light     [3] Reckless Strike");}
            if(type == 3){System.out.println("Skill: [1]Life Steal     [2] Charged Strike     [3] Bleeding Edge");}
            Scanner num2 = new Scanner(System.in);
            skill = num2.nextInt();
            if(type == 1){
                if((skill == 2 && getMp() < 5) || (skill == 1 && getMp() < 4)){
                    System.out.println("Not enough mana");
                }
                else return skill;
            }
            if(type == 2){
                if(skill == 3 && getMp() < 5) {
                    System.out.println("Not enough mana");
                }
                else return skill;
            }
            if(type == 3){
                if((skill == 3 && getMp() < 5) || (skill == 2 && getMp() < 4)){
                    System.out.println("Not enough mana");
                }
                else return skill;
            }
            if(skill == 1764) break;
            else System.out.println("Enter a valid option!");
        }while(true);
        return skill;
    }

    public String toString() {
        String[] TYPE = {"Archer", "Swordsman", "Assassin"};
        return "RPGCharacter{" +
                TYPE[type - 1] + " " +
                getName() + " " +
                ", hp = " + getHp() +
                ", mp = " + getMp() +
                '}';
    }
}

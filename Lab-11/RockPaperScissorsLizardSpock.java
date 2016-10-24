package Lab11;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by brand on 10/24/2016.
 */
public class RockPaperScissorsLizardSpock extends Frame{
    private Button RPSLS;
    private Button ok;
    private Label header;
    private Label npc;
    private Label you;
    private Label win;
    private Label p1;
    private Label p2;
    private TextArea now;
    private Checkbox a,b,c,d,e;
    CheckboxGroup cbg;
    private int yscore = 0;
    private int cscore = 0;

    private Random rand = new Random();

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public RockPaperScissorsLizardSpock(){
        setLayout(new GridLayout(6, 1));
        cbg = new CheckboxGroup();
        a = new Checkbox("Rock", cbg, false);
        b = new Checkbox("Paper", cbg, false);
        c = new Checkbox("Scissors", cbg, false);
        d = new Checkbox("Lizard", cbg, false);
        e = new Checkbox("Spock", cbg, false);
        header = new Label("Your choice: ");
        npc = new Label("");
        you = new Label("");
        win = new Label("");
        p1 = new Label("Player's Score: " + yscore);
        p2 = new Label("Computer's Score: " + cscore);
        now = new TextArea("Result: ", 1, 1);
        add(header);
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(now);
        RPSLS = new Button("RockPaperScissorsLizardSpock");
        add(RPSLS);
        RPSLS.addActionListener(new MyActionListener());
        add(p1);
        add(p2);


        setTitle("RockPaperScissorsLizardSpock");
        setSize(600, 600);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int ran = randInt(1, 5);
            if(ran == 1) npc.setText("Computer chose Rock");
            else if(ran == 2) npc.setText("Computer chose Paper");
            else if(ran == 3) npc.setText("Computer chose Scissor");
            else if(ran == 4) npc.setText("Computer chose Lizard");
            else npc.setText("Computer chose Spock");

            String yours = cbg.getSelectedCheckbox().getLabel();
            int choice;
            if(yours.equals("Rock")) {
                choice = 1;
                you.setText("You chose Rock");
            }
            else if(yours.equals("Paper")) {
                choice = 2;
                you.setText("You chose Paper");
            }
            else if(yours.equals("Scissors")) {
                choice = 3;
                you.setText("You chose Scissors");
            }
            else if(yours.equals("Lizard")) {
                choice = 4;
                you.setText("You chose Lizard");
            }
            else {
                choice = 5;
                you.setText("You chose Spock");
            }

            if(choice == 1 && (ran == 4 || ran == 3)) {
                win.setText("You win this round");
                yscore++;
            }
            else if(choice == 2 && (ran == 1 || ran == 5)) {
                win.setText("You win this round");
                yscore++;
            }
            else if(choice == 3 && (ran == 2 || ran == 4)) {
                win.setText("You win this round");
                yscore++;
            }
            else if(choice == 4 && (ran == 5 || ran == 2)) {
                win.setText("You win this round");
                yscore++;
            }
            else if(choice == 5 && (ran == 1 || ran == 3)) {
                win.setText("You win this round");
                yscore++;
            }
            else if(choice == 1 && (ran == 2 || ran == 5)) {
                win.setText("Computer wins this round");
                cscore++;
            }
            else if(choice == 2 && (ran == 3 || ran == 4)) {
                win.setText("Computer wins this round");
                cscore++;
            }
            else if(choice == 3 && (ran == 1 || ran == 5)) {
                win.setText("Computer wins this round");
                cscore++;
            }
            else if(choice == 4 && (ran == 1 || ran == 3)) {
                win.setText("Computer wins this round");
                cscore++;
            }
            else if(choice == 5 && (ran == 2 || ran == 4)) {
                win.setText("Computer wins this round");
                cscore++;
            }
            else win.setText("Draw");

            now.setText("Result: " + "\n" + you.getText() + "\n" + npc.getText() + "\n\n" + win.getText());
            p1.setText("Player's score: " + yscore);
            p2.setText("Computer's score: " + cscore);
            if(yscore == 5){
                dia(1);
            }
            if(cscore == 5){
                dia(2);
            }
        }

        public void dia(int x){
            cscore = 0;
            yscore = 0;
            Label s;
            if(x == 1) s = new Label("Game over! Player won.");
            else s = new Label("Game over! Computer won.");
            p1.setText("Player's score: " + yscore);
            p2.setText("Computer's score: " + cscore);
            Dialog d = new Dialog(((Window)null),s.getText());
            ok = new Button("OK");
            d.setSize(250, 100);
            d.setVisible(true);
            d.add(ok);
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    d.setVisible(false);
                }
            });
        }
    }

    public static void main(String[] args) {
        new RockPaperScissorsLizardSpock();
    }
}

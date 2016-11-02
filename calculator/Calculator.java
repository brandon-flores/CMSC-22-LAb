package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * Created by brandon on 10/28/2016.
 */
public class Calculator extends JFrame{
    private JButton buttonplus, buttonminus, buttontimes, buttondivide, bpoint, bequals, clear, allclear;
    private JTextArea display;
    private JButton[] nums = new JButton[10];
    private BigDecimal a, b, answer;
    private JPanel buttons;
    private int ope;
    private boolean flag = false, nega = true;

    Calculator(){
        Font f = new Font("Arial", Font.BOLD, 20);
        for(int i = 0; i < 10; i++) {
            nums[i] = new JButton("" + i);
            nums[i].setBackground(Color.GRAY);
            nums[i].setFont(f);
        }
        bpoint = new JButton(".");
        bequals = new JButton("=");
        buttonplus = new JButton("+");
        buttonminus = new JButton("-");
        buttontimes = new JButton("*");
        buttondivide = new JButton("/");
        clear = new JButton("Clear");
        allclear = new JButton("All Clear");
        display = new JTextArea();
        buttons = new JPanel(new GridLayout(4, 4, 0, 0));

        display.setBounds(0, 0, 400, 100);
        display.setEditable(false);
        display.setFont(new Font("Times New Roman", Font.BOLD, 25));
        display.setBackground(Color.LIGHT_GRAY);

        clear.setFont(f);       clear.setBounds(0, 100, 200, 75);       clear.setForeground(Color.WHITE);
        allclear.setFont(f);    allclear.setBounds(200, 100, 200, 75);  allclear.setForeground(Color.WHITE);
        clear.setBackground(Color.DARK_GRAY);       allclear.setBackground(Color.DARK_GRAY);

        buttonplus.setFont(f);      buttonplus.setForeground(Color.WHITE);      buttonplus.setBackground(Color.DARK_GRAY);
        buttonminus.setFont(f);     buttonminus.setForeground(Color.WHITE);     buttonminus.setBackground(Color.DARK_GRAY);
        buttontimes.setFont(f);     buttontimes.setForeground(Color.WHITE);     buttontimes.setBackground(Color.DARK_GRAY);
        bpoint.setFont(f);          bpoint.setForeground(Color.WHITE);          bpoint.setBackground(Color.DARK_GRAY);
        bequals.setFont(f);         bequals.setForeground(Color.WHITE);         bequals.setBackground(Color.DARK_GRAY);
        buttondivide.setFont(f);    buttondivide.setForeground(Color.WHITE);    buttondivide.setBackground(Color.DARK_GRAY);

        buttons.add(nums[7]);   buttons.add(nums[8]);   buttons.add(nums[9]);   buttons.add(buttonplus);
        buttons.add(nums[4]);   buttons.add(nums[5]);   buttons.add(nums[6]);   buttons.add(buttonminus);
        buttons.add(nums[1]);   buttons.add(nums[2]);   buttons.add(nums[3]);   buttons.add(buttontimes);
        buttons.add(nums[0]);   buttons.add(bpoint);    buttons.add(bequals);   buttons.add(buttondivide);
        buttons.setBounds(0, 175, 400, 300);

        nums[1].addActionListener(new MyActionListener());      nums[2].addActionListener(new MyActionListener());
        nums[3].addActionListener(new MyActionListener());      nums[4].addActionListener(new MyActionListener());
        nums[5].addActionListener(new MyActionListener());      nums[6].addActionListener(new MyActionListener());
        nums[7].addActionListener(new MyActionListener());      nums[8].addActionListener(new MyActionListener());
        nums[9].addActionListener(new MyActionListener());      nums[0].addActionListener(new MyActionListener());
        buttonplus.addActionListener(new MyActionListener());   buttonminus.addActionListener(new MyActionListener());
        buttontimes.addActionListener(new MyActionListener());  buttondivide.addActionListener(new MyActionListener());
        bequals.addActionListener(new MyActionListener());      bpoint.addActionListener(new MyActionListener());
        clear.addActionListener(new MyActionListener());        allclear.addActionListener(new MyActionListener());

        add(display);
        add(clear); add(allclear);
        add(buttons);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(403,505);
        this.setVisible(true);
        this.setResizable(false);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == nums[1]){
                change();
                display.setText(display.getText() + "1");
            }
            if(e.getSource() == nums[2]) {
                change();
                display.setText(display.getText() + "2");
            }
            if(e.getSource() == nums[3]) {
                change();
                display.setText(display.getText() + "3");
            }
            if(e.getSource() == nums[4]) {
                change();
                display.setText(display.getText() + "4");
            }
            if(e.getSource() == nums[5]) {
                change();
                display.setText(display.getText() + "5");
            }
            if(e.getSource() == nums[6]) {
                change();
                display.setText(display.getText() + "6");
            }
            if(e.getSource() == nums[7]) {
                change();
                display.setText(display.getText() + "7");
            }
            if(e.getSource() == nums[8]) {
                change();
                display.setText(display.getText() + "8");
            }
            if(e.getSource() == nums[9]) {
                change();
                display.setText(display.getText() + "9");
            }
            if(e.getSource() == nums[0]) {
                change();
                display.setText(display.getText() + "0");
            }
            if(e.getSource() == buttonplus){
                a = new BigDecimal(display.getText());
                display.setText("+");
                ope = 1;
                flag = true;
                nega = true;
            }
            if(e.getSource() == buttonminus){
                if(nega){
                    display.setText("-");
                    flag = false;
                    nega = false;
                }else{
                    a = new BigDecimal(display.getText());
                    display.setText("-");
                    flag = true;
                    ope = 2;
                    nega = true;
                }
            }
            if(e.getSource() == buttontimes){
                a = new BigDecimal(display.getText());
                display.setText("*");
                flag = true;
                nega = true;
                ope = 3;
            }
            if(e.getSource() == buttondivide){
                a = new BigDecimal(display.getText());
                display.setText("/");
                flag = true;
                nega = true;
                ope = 4;
            }
            if(e.getSource() == bequals){
                b = new BigDecimal(display.getText());
                if(ope == 1) answer = a.add(b);
                if(ope == 2) answer = a.subtract(b);
                if(ope == 3) answer = a.multiply(b);
                if(ope == 4) answer = a.divide(b);
                display.setText(answer.toEngineeringString());
                flag = true;
                nega = false;
            }
            if(e.getSource() == bpoint){
                display.setText(display.getText() + ".");
            }
            if(e.getSource() == allclear){
                display.setText("");
            }
            if(e.getSource() == clear){
                String str = display.getText(), str1 = "";
                for(int i = 0; i < str.length() - 1; i++){
                    str1 += str.charAt(i);
                }
                display.setText(str1);
            }
        }
    }

    private void change(){
        if(flag){
            flag = false;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
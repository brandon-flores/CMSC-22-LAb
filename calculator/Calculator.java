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
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonplus, buttonminus, buttontimes, buttondivide, bpoint, bequals, clear, allclear;
    JTextArea display;
    BigDecimal a, b, answer;
    int ope;
    boolean flag = false;

    Calculator(){
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button0 = new JButton("0");
        bpoint = new JButton(".");
        bequals = new JButton("=");
        buttonplus = new JButton("+");
        buttonminus = new JButton("-");
        buttontimes = new JButton("*");
        buttondivide = new JButton("/");
        clear = new JButton("Clear");
        allclear = new JButton("All Clear");
        display = new JTextArea();
        Font f = new Font("Arial", Font.BOLD, 20);

        display.setBounds(0, 0, 400, 100);
        display.setEditable(false);
        display.setFont(new Font("Times New Roman", Font.BOLD, 25));
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        clear.setBounds(0, 100, 200, 75);
        clear.setFont(f);
        allclear.setBounds(200, 100, 200, 75);
        allclear.setFont(f);
        button7.setBounds(0, 175, 100, 75);
        button7.setFont(f);
        button8.setBounds(100, 175, 100, 75);
        button8.setFont(f);
        button9.setBounds(200, 175, 100, 75);
        button9.setFont(f);
        buttonplus.setBounds(300, 175, 100, 75);
        buttonplus.setFont(f);
        button4.setBounds(0, 250, 100, 75);
        button4.setFont(f);
        button5.setBounds(100, 250, 100, 75);
        button5.setFont(f);
        button6.setBounds(200, 250, 100, 75);
        button6.setFont(f);
        buttonminus.setBounds(300, 250, 100, 75);
        buttonminus.setFont(f);
        button1.setBounds(0, 325, 100, 75);
        button1.setFont(f);
        button2.setBounds(100, 325, 100, 75);
        button2.setFont(f);
        button3.setBounds(200, 325, 100, 75);
        button3.setFont(f);
        buttontimes.setBounds(300, 325, 100, 75);
        buttontimes.setFont(f);
        bpoint.setBounds(0, 400, 100, 75);
        bpoint.setFont(f);
        button0.setBounds(100, 400, 100, 75);
        button0.setFont(f);
        bequals.setBounds(200, 400, 100, 75);
        bequals.setFont(f);
        buttondivide.setBounds(300, 400, 100, 75);
        buttondivide.setFont(f);

        button1.addActionListener(new MyActionListener());
        button2.addActionListener(new MyActionListener());
        button3.addActionListener(new MyActionListener());
        button4.addActionListener(new MyActionListener());
        button5.addActionListener(new MyActionListener());
        button6.addActionListener(new MyActionListener());
        button7.addActionListener(new MyActionListener());
        button8.addActionListener(new MyActionListener());
        button9.addActionListener(new MyActionListener());
        button0.addActionListener(new MyActionListener());
        buttonplus.addActionListener(new MyActionListener());
        buttonminus.addActionListener(new MyActionListener());
        buttontimes.addActionListener(new MyActionListener());
        buttondivide.addActionListener(new MyActionListener());
        bequals.addActionListener(new MyActionListener());
        bpoint.addActionListener(new MyActionListener());
        clear.addActionListener(new MyActionListener());
        allclear.addActionListener(new MyActionListener());

        add(display);
        add(clear);
        add(allclear);
        add(button7);
        add(button8);
        add(button9);
        add(button4);
        add(button5);
        add(button6);
        add(button1);
        add(button2);
        add(button3);
        add(bpoint);
        add(button0);
        add(bequals);
        add(buttonplus);
        add(buttonminus);
        add(buttontimes);
        add(buttondivide);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(416,514);
        this.setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                change();
                display.setText(display.getText() + "1");
            }
            if(e.getSource() == button2) {
                change();
                display.setText(display.getText() + "2");
            }
            if(e.getSource() == button3) {
                change();
                display.setText(display.getText() + "3");
            }
            if(e.getSource() == button4) {
                change();
                display.setText(display.getText() + "4");
            }
            if(e.getSource() == button5) {
                change();
                display.setText(display.getText() + "5");
            }
            if(e.getSource() == button6) {
                change();
                display.setText(display.getText() + "6");
            }
            if(e.getSource() == button7) {
                change();
                display.setText(display.getText() + "7");
            }
            if(e.getSource() == button8) {
                change();
                display.setText(display.getText() + "8");
            }
            if(e.getSource() == button9) {
                change();
                display.setText(display.getText() + "9");
            }
            if(e.getSource() == button0) {
                change();
                display.setText(display.getText() + "0");
            }
            if(e.getSource() == buttonplus){
                a = new BigDecimal(display.getText());
                display.setText("+");
                ope = 1;
                flag = true;
            }
            if(e.getSource() == buttonminus){
                a = new BigDecimal(display.getText());
                display.setText("-");
                flag = true;
                ope = 2;
            }
            if(e.getSource() == buttontimes){
                a = new BigDecimal(display.getText());
                display.setText("*");
                flag = true;
                ope = 3;
            }
            if(e.getSource() == buttondivide){
                a = new BigDecimal(display.getText());
                display.setText("/");
                flag = true;
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

    public void change(){
        if(flag){
            flag = false;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }

}

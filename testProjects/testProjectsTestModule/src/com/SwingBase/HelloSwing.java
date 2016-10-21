package com.SwingBase;

import javax.swing.*;
import java.util.concurrent.*;

/**
 * Created by liu_y.
 * On 2016/10/7.
 */
public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A Lable");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setVisible(true);
        //TimeUnit.SECONDS.sleep(1);
        label.setText("Hey! This is Different!");
        System.out.println("sdsd");

    }
}

package com.karaushu.main;

import javax.swing.*;

/**
 * Created by andy on 07.09.15.
 */
public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

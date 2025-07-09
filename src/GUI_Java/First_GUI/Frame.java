package GUI_Java.First_GUI;

import javax.swing.*;
import java.awt.*;

public class Frame {

    // Run Function -> Creates the Window
    public void run() {
        System.out.println("Application is Running!");

        JFrame window = new JFrame();
        window.setTitle("My First Java GUI");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.PINK);
        window.setVisible(true);
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setSize(325,325);
    }
}

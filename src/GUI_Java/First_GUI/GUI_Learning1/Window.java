package GUI_Java.First_GUI.GUI_Learning1;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Window {

    public void start() {
        JFrame window = new JFrame(); // Create an JFrame window Object
        JLabel label = new JLabel();

        label.setText("Hello, World!");
        label.setForeground(new Color(0, 144, 246));
        label.setFont(new Font("sans-serif", Font.PLAIN, 14));

        window.setTitle("My 2nd GUI Window"); // sets the title of the window
        window.setSize(400, 400); // sets the size of the window ( Will be Overridden by window.pack(); )
        window.setLocationRelativeTo(null); // sets the location of the window (null = Center of screen)
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lets you close the window with the 'X'.
        window.setResizable(false); // Is the screen resizeable
        window.setVisible(true); // makes the window visible

        window.add(label);

        try {
            ImageIcon Image = new ImageIcon("icon.png");
            window.setIconImage(Image.getImage());
        } catch(Exception e) {
            System.out.println("Image not found, using basic java image.");
        }
    }
}

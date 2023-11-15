package model;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MyFrame extends JFrame 
{
    public MyFrame(int frameWidth, int frameHeight) 
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int framePositionHorizontal = (screenWidth - frameWidth) / 2;
        int framePositionVertical = (screenHeight - frameHeight) / 2;

        this.setBounds(framePositionHorizontal, framePositionVertical, frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

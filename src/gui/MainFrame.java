package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private TextPanel textPanel;




    public MainFrame() {
        super("Raamatud");
        setLayout(new BorderLayout());

        textPanel = new TextPanel();

        add(textPanel, BorderLayout.CENTER);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}
